package com.axis.service;

import java.util.List;

import com.axis.entity.Customer;

public interface CustomerService {
	Customer signUp(Customer customer);
	List<Customer> getAllCustomers();
	Customer getCustomerBycustomerId(long customerId);
	Customer updateCustomerById(long customerId,Customer customer);
    String deleteCustomerById(long customerId);

}
