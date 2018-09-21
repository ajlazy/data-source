package com.capgemini.bankApp.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.bankApp.dbutil.DbUtil;
import com.capgemini.bankApp.exceptions.LowBalanceException;
import com.capgemini.bankApp.repository.BankAccountRepository;
import com.capgemini.bankApp.service.BankAccountService;
@Service
public class BankAccountServiceImpl implements BankAccountService {
	@Autowired
	private BankAccountRepository bankAccountRepository;
	@Autowired
	DbUtil dbUtil;

//	public void setBankAccountRepository(BankAccountRepository bankAccountRepository) {
//		this.bankAccountRepository = bankAccountRepository;
//	}
	
//	@Autowired
//	private BankAccountServiceImpl(BankAccountRepository bankAccountRepository) {
//		super();
//		this.bankAccountRepository = bankAccountRepository;
//	}

	@Override
	public double getBalance(long accountId) {
		return bankAccountRepository.getBalance(accountId);
	}
	
	@Override
	public double withdraw(long accountId, double amount) throws LowBalanceException {
		double balance = bankAccountRepository.getBalance(accountId);
		if (balance >= 0) {
			if (balance - amount >= 0) {
				bankAccountRepository.updateBalance(accountId, balance - amount);
				return bankAccountRepository.getBalance(accountId);
			} else
				throw new LowBalanceException("You Dont Have sufficient balance");
		}
		return -1;
	}

	@Override
	public double deposit(long accountId, double amount) {
		double balance = bankAccountRepository.getBalance(accountId);
		if (balance >= 0) {
			bankAccountRepository.updateBalance(accountId, balance + amount);
			return bankAccountRepository.getBalance(accountId);
		}
		return balance;
	}

	@Override
	public boolean fundTransfer(long fromAccount, long toAccount, double amount) throws LowBalanceException {
		String query = "select accountId from customers where accountId =?";
		try (Connection connection = dbUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, (int) toAccount);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				if (withdraw(fromAccount, amount) >= 0) {
					deposit(toAccount, amount);
					return true;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
