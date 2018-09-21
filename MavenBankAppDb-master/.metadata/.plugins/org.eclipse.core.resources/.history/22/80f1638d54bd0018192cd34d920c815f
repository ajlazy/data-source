package com.capgemini.bankApp.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capgemini.bankApp.dbutil.DbUtil;
import com.capgemini.bankApp.repository.BankAccountRepository;
@Repository
public class BankAccountRepositoryImpl implements BankAccountRepository {

//	private HashSet<BankAccount> bankAccounts;
//	
	public BankAccountRepositoryImpl() {
	super();
//	bankAccounts = new HashSet<>();
//	bankAccounts.add(new BankAccount(1234,"Tom","SAVINGS", 35000));
//	bankAccounts.add(new BankAccount(1235,"Marry","SAVINGS",33000));
//	bankAccounts.add(new BankAccount(1236,"Clary","SAVINGS",40000));
	}
	@Autowired
	DbUtil dbUtil;
	
	@Override
	public double getBalance(long accountId) {
		String query = "select accountBalance FROM bankAccounts where accountId=?";
		try (Connection connection = dbUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, (int) accountId);
			ResultSet result = statement.executeQuery();
			if(result.next())
			{
				return result.getDouble(1);
			}
			}
	catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public boolean updateBalance(long accountId, double newBalance) {
		
		String query = "UPDATE bankAccounts SET accountBalance=? where accountId=?";
		try (Connection connection = dbUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(2, (int) accountId);
			statement.setDouble(1, newBalance);
			if (statement.executeUpdate() == 1)
				return true;
		return false;
	} catch (SQLException e) {
		e.printStackTrace();
	}
		return false;
}

}
