package com.axis.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(uniqueConstraints=@UniqueConstraint(columnNames={"customerEmail","customerNumber"}))

public class Customer {
	
	@Id
    @SequenceGenerator(name = "customer_id", allocationSize = 1,initialValue =100000000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "customer_id")
	
	private long customerId;
	
   
	private String customerEmail;
	
	
	private long customerNumber;
	private String customerPassword;
	private String accountNumber;
	private double balance;
	
	
	public String getCustomerEmail() {
		return customerEmail;
	}


	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}


	public long getCustomerNumber() {
		return customerNumber;
	}


	public void setCustomerNumber(long customerNumber) {
		this.customerNumber = customerNumber;
	}


	
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}


	public long getCustomerId() {
		return customerId;
	}


	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}


	public String getCustomerPassword() {
		return customerPassword;
	}


	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}


	public String getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}


	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}




	

	
	
	
	

}
