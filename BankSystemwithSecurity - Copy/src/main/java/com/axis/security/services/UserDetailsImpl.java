package com.axis.security.services;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.axis.models.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserDetailsImpl implements UserDetails {
  private static final long serialVersionUID = 1L;

  private long customerId;

  private String username;

  private String customerEmail;

  private String customerPassword;
  
  private String accountNumber;
  private double balance;
	
  
  private Collection<? extends GrantedAuthority> authorities;



public UserDetailsImpl(long customerId, String username, String customerEmail, String customerPassword,
		String accountNumber, double balance, Collection<? extends GrantedAuthority> authorities) {
	super();
	this.customerId = customerId;
	this.username = username;
	this.customerEmail = customerEmail;
	this.customerPassword = customerPassword;
	this.accountNumber = accountNumber;
	this.balance = balance;
	this.authorities = authorities;
}

public static UserDetailsImpl build(User user) {
    List<GrantedAuthority> authorities = user.getRoles().stream()
        .map(role -> new SimpleGrantedAuthority(role.getName().name()))
        .collect(Collectors.toList());

    return new UserDetailsImpl(
    	user.getCustomerId(),
        user.getUsername(), 
        user.getCustomerEmail(),
        user.getCustomerPassword(), 
        user.getAccountNumber(),
        user.getBalance(),
        authorities);
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }


public long getCustomerId() {
	return customerId;
}

public void setCustomerId(int customerId) {
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

public static long getSerialversionuid() {
	return serialVersionUID;
}

public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
	this.authorities = authorities;
}

@Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    UserDetailsImpl user = (UserDetailsImpl) o;
    return Objects.equals(customerId, user.customerId);
  }

@Override
public String getPassword() {
	// TODO Auto-generated method stub
	return null;
}


}
