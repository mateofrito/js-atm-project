package io.mattfry.atmprojectjs.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Account {
	
	@Id
	@GeneratedValue
	private Long id;
	int accountNumber;
	private String accountType;
	private double balance;
	private double withdraw;
	private double deposit;
	
	
	
	
	
	public Account() {}

	public Account(String accountType, int accountNumber, double balance) {
		this.accountType = accountType;
		this.accountNumber = accountNumber;
		this.balance = balance;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public double getBalance() {
		return balance;
	}
	
	

	public double getWithdraw() {
		return withdraw;
	}

	public double getDeposit() {
		return deposit;
	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", accountType=" + accountType + ", balance=" + balance
				+ "]";
	}

	
}
