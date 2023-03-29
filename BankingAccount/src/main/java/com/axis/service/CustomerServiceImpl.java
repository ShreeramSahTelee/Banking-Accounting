package com.axis.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Random;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.entity.Customer;
import com.axis.exception.CustomerIdNotFoundException;
import com.axis.repository.CustomerRepository;
import com.axis.utility.AppConstant;
@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	CustomerRepository customerRepository;

	
	@Override
	public Customer signUp(Customer customer) {
        customer.setAccountNumber(generateAccountNumber());
        customer.setBalance(100);
        return customerRepository.save(customer);
    }
	
	 
	
	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}



	@Override
	public Customer getCustomerBycustomerId(long customerId) {
		Optional<Customer> opt=customerRepository.findById(customerId);
		if(opt.isPresent()) {
			return opt.get();
		}
		
		else {
			throw new CustomerIdNotFoundException(AppConstant.CUSTOMER_ID_NOT_FOUND_MESSAGE);
		}
	}



	@Override
	public Customer updateCustomerById(long customerId, Customer customer) {
		Optional<Customer> opt=customerRepository.findById(customerId);
		if(opt.isPresent()) {
			return customerRepository.save(customer);
		}
		
		else {
			throw new CustomerIdNotFoundException(AppConstant.CUSTOMER_ID_NOT_FOUND_MESSAGE);
		}
	}



	@Override
	public String deleteCustomerById(long customerId) {
		Optional<Customer> opt=customerRepository.findById(customerId);
		if(opt.isPresent()) {
			customerRepository.deleteById(customerId);
			return "customer is deleted";
		}
		
		else {
			throw new CustomerIdNotFoundException(AppConstant.CUSTOMER_ID_NOT_FOUND_MESSAGE);
		}
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
