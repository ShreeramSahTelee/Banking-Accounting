package com.axis.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.models.User;
import com.axis.repository.UserRepository;

@Service
public class CustomerServiceImpl {
	
	@Autowired
	UserRepository customerRepository;

	public User signUp(User customer) {
        return customerRepository.save(customer);
	}

	
}
