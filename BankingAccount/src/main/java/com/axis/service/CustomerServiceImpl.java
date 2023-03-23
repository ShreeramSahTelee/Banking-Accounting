package com.axis.service;

import java.math.BigDecimal;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.entity.Customer;
import com.axis.repository.CustomerRepository;
@Service
public class CustomerServiceImpl {
	@Autowired
	CustomerRepository customerRepository;

	public Customer signUp(Customer customer) {
        
      
        
        customer.setAccountNumber(generateAccountNumber());
        customer.setBalance(new BigDecimal("100"));
        return customerRepository.save(customer);
    }
	
	private String generateAccountNumber() {
	  
	    Random random = new Random();
	    StringBuilder accountNumber = new StringBuilder();
	    for (int i = 0; i < 12; i++) {
	        accountNumber.append(random.nextInt(10));
	    }
	    return accountNumber.toString();
	}
}
