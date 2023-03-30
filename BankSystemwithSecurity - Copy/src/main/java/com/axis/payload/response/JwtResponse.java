package com.axis.payload.response;

import java.util.List;

public class JwtResponse {
  private String token;
  private String type = "Bearer";
  private long customerId;
  private String username;
  private String customerEmail;
  
  
  private List<String> roles;


public String getToken() {
	return token;
}


public void setToken(String token) {
	this.token = token;
}


public String getType() {
	return type;
}


public void setType(String type) {
	this.type = type;
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


public List<String> getRoles() {
	return roles;
}


public void setRoles(List<String> roles) {
	this.roles = roles;
}


public JwtResponse(String token, long customerId, String username, String customerEmail, List<String> roles) {
	super();
	this.token = token;
	this.customerId = customerId;
	this.username = username;
	this.customerEmail = customerEmail;
	this.roles = roles;
}

  




 
}
