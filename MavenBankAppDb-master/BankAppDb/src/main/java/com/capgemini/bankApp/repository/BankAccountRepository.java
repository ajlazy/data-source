package com.capgemini.bankApp.repository;

public interface BankAccountRepository {

	public double getBalance(long accountId);

	public boolean updateBalance(long accountId, double newBalance);
}
