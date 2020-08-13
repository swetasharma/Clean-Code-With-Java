package com.spring.boot.designpattern;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class DesignPatternApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesignPatternApplication.class, args);
		Account accountBuy = new Account();
		System.out.println("Balance before the transaction: "+ accountBuy.getBalance());
		TransactionType.BUY.doTransactionOperation(accountBuy, BigDecimal.valueOf(100));
		System.out.println("Balance after the transaction: "+ accountBuy.getBalance());

		Account accountSell = new Account();
		System.out.println("Balance before the transaction: "+ accountSell.getBalance());
		TransactionType.SELL.doTransactionOperation(accountSell, BigDecimal.valueOf(100));
		System.out.println("Balance after the transaction: "+ accountSell.getBalance());
	}
}
