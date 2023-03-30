package com.axis.models;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"customerEmail","username"}))
public class User {

   @SequenceGenerator(name = "customer_id", allocationSize = 1,initialValue = 100000000)
   @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "customer_id")
   @Id
   private long customerId;
   
  private String username;

  private String customerEmail;

  private String customerPassword;
  
  private String accountNumber;
  private double balance;
	
  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(  name = "user_roles", 
        joinColumns = @JoinColumn(name = "customerId"), 
        inverseJoinColumns = @JoinColumn(name = "role_id"))
  private Set<Role> roles = new HashSet<>();

  public User() {
	super();
	// TODO Auto-generated constructor stub
}

public long getCustomerId() {
	return customerId;
}

public void setCustomerId(long customerId) {
	this.customerId = customerId;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getCustomerEmail() {
	return customerEmail;
}

public void setCustomerEmail(String customerEmail) {
	this.customerEmail = customerEmail;
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

public Set<Role> getRoles() {
	return roles;
}

public void setRoles(Set<Role> roles) {
	this.roles = roles;
}

public User(String username, String customerEmail, String customerPassword) {
	super();
	this.username = username;
	this.customerEmail = customerEmail;
	this.customerPassword = customerPassword;
}
  









}
