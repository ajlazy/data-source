package com.capgemini.bankApp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.capgemini.bankApp.config.AppConfig;
import com.capgemini.bankApp.controller.BankAccountController;
import com.capgemini.bankApp.dbutil.DbUtil;
import com.capgemini.bankApp.exceptions.LowBalanceException;

public class Application {
	public static void main(String args[]) {

		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		BankAccountController bankAccountController = context.getBean("bankAccountController",
				BankAccountController.class);
		
		DbUtil dbUtil = context.getBean(DbUtil.class);
		dbUtil.getConnection();

		System.out.println(bankAccountController.getBalance(12343));
		try {

			System.out.println("\n" + bankAccountController.getBalance(12344));
			System.out.println(bankAccountController.withdraw(12344, 1000));
			System.out.println(
					"\n" + bankAccountController.getBalance(12344) + "\t" + bankAccountController.getBalance(1234));
			bankAccountController.fundTransfer(12344, 12343, 1000);
			System.out.println(bankAccountController.getBalance(12344) + "\t" + bankAccountController.getBalance(12343));
		} catch (LowBalanceException e) {
			e.printStackTrace();
		}

	
	}
}
