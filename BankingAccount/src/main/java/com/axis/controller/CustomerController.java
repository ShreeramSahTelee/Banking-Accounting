package com.axis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axis.entity.Customer;
import com.axis.service.CustomerService;
import com.axis.service.CustomerServiceImpl;

@RestController
@RequestMapping
public class CustomerController {
	@Autowired
	CustomerService customerService;
	
	@PostMapping("/signUp")
	public ResponseEntity<Customer> signUp(@RequestBody Customer customer){
		return new ResponseEntity<Customer>(customerService.signUp(customer),HttpStatus.OK);
	}
    
	@GetMapping("/getAllCustomer")
	public ResponseEntity<List<Customer>> getAll(){
		return new ResponseEntity<List<Customer>>(customerService.getAllCustomers(),HttpStatus.OK);
	}
	
	@GetMapping("/getById/{customerId}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable long customerId){
		return new ResponseEntity<Customer>(customerService.getCustomerBycustomerId(customerId),HttpStatus.OK);
	}
	
	@PutMapping("/updateById/{customerId}")
	public ResponseEntity<Customer> updateCustomerById(@PathVariable long customerId,@RequestBody Customer customer){
		return new ResponseEntity<Customer>(customerService.updateCustomerById(customerId, customer),HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteById/{customerId}")
	public ResponseEntity<String> deleteCustomer(@PathVariable long customerId){
		return new ResponseEntity<String>(customerService.deleteCustomerById(customerId),HttpStatus.OK);
	}
	
	
	
	
	
}
