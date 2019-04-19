package io.mattfry.atmprojectjs.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Transaction {
	

	@Id
	@GeneratedValue
	private Long id;
	String transactionSource;
	int transactionNumber;
	double amount;
	
	
public Transaction() {}


public Transaction(String transactionSource, int transactionNumber, double amount) {
	this.transactionSource = transactionSource;
	this.transactionNumber = transactionNumber;
	this.amount = amount;
	// TODO Auto-generated constructor stub
}




public Long getId() {
	return id;
}


public String getTransactionSource() {
	return transactionSource;
}


public int getTransactionNumber() {
	return transactionNumber;
}


public double getAmount() {
	return amount;
}
	
@Override
public String toString() {
	return "Transaction [id=" + id + ", transactionSource=" + transactionSource + ", transactionNumber="
			+ transactionNumber + ", amount=" + amount + "]";
}
	
	
}