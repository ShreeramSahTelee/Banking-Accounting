package com.axis.entity;

import java.math.BigInteger;
import java.time.LocalDateTime;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

public class Account {
	
	    @Id
	    @SequenceGenerator(name = "account_no", allocationSize = 1,initialValue = 1111200230)
	    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "account_no")
	    long account_number;
	  //  String account_name;
	  //  String account_type;
	    LocalDateTime date_created;
	

}
