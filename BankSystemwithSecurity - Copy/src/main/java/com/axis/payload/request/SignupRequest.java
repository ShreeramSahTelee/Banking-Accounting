package com.axis.payload.request;

import java.math.BigDecimal;
import java.util.Set;

import javax.validation.constraints.*;

public class SignupRequest {
 
  @NotBlank
  private String username;
  
  @NotBlank
  @Size(max = 50)
  @Email
  private String customerEmail;

  private Set<String> role;

  @NotBlank
  @Size(min = 6, max = 40)
  private String customerPassword;
  

  private String accountNumber;
  private BigDecimal balance;
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
public Set<String> getRole() {
	return role;
}
public void setRole(Set<String> role) {
	this.role = role;
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
public BigDecimal getBalance() {
	return balance;
}
public void setBalance(BigDecimal balance) {
	this.balance = balance;
}
  

}
