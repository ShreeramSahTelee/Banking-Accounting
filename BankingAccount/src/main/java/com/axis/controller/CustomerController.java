package com.axis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axis.entity.Customer;
import com.axis.service.CustomerServiceImpl;

@RestController
@RequestMapping
public class CustomerController {
	@Autowired
	CustomerServiceImpl customerServiceImpl;
	
	@PostMapping("/signUp")
	public ResponseEntity<Customer> signUp(@RequestBody Customer customer){
		return new ResponseEntity<Customer>(customerServiceImpl.signUp(customer),HttpStatus.OK);
	}

}
