package com.axis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.axis.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
	 Customer findByCustomerId(long customerId);

	Customer findByAccountNumber(String beneficiaryAccountNumber);

}
