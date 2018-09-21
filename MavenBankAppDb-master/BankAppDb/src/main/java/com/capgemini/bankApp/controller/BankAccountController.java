package com.capgemini.bankApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.capgemini.bankApp.exceptions.LowBalanceException;
import com.capgemini.bankApp.service.BankAccountService;
@Controller
public class BankAccountController {
	@Autowired
	private BankAccountService bankAccountService;

//	public void setBankAccountService(BankAccountService bankAccountService) {
//		this.bankAccountService = bankAccountService;
//	}
	
//	@Autowired
//	private BankAccountController(BankAccountService bankAccountService) {
//		super();
//		this.bankAccountService = bankAccountService;
//	}
//	
	public double getBalance(long accountId) {
		return bankAccountService.getBalance(accountId);
	}

	public double withdraw(long accountId, double amount) throws LowBalanceException {
		return bankAccountService.withdraw(accountId, amount);
	}

	public double deposit(long accountId, double amount) {
		return bankAccountService.deposit(accountId, amount);
	}

	public boolean fundTransfer(long fromAccount, long toAccount, double amount) throws LowBalanceException {
		return bankAccountService.fundTransfer(fromAccount, toAccount, amount);
	}

}
