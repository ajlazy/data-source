package com.capgemini.bankApp.repository.impl;

import java.util.HashSet;

import org.springframework.stereotype.Repository;

import com.capgemini.bankApp.entities.BankAccount;
import com.capgemini.bankApp.repository.BankAccountRepository;
@Repository
public class BankAccountRepositoryImpl implements BankAccountRepository {

	private HashSet<BankAccount> bankAccounts;
	
	public BankAccountRepositoryImpl() {
	super();
	bankAccounts = new HashSet<>();
	bankAccounts.add(new BankAccount(1234,"Tom","SAVINGS", 35000));
	bankAccounts.add(new BankAccount(1235,"Marry","SAVINGS",33000));
	bankAccounts.add(new BankAccount(1236,"Clary","SAVINGS",40000));
	}
	
	@Override
	public double getBalance(long accountId) {
		
		for (BankAccount bankAccount : bankAccounts) {
			if(bankAccount.getAccountId()==accountId)
			{
				return bankAccount.getAccountBalance();
			}
		}
		return -1;
	}

	@Override
	public boolean updateBalance(long accountId, double newBalance) {
		for (BankAccount bankAccount : bankAccounts) {
			if(bankAccount.getAccountId()==accountId)
			{
				bankAccount.setAccountBalance(newBalance);
				return true;
			}
		}
		return false;
	}

}
