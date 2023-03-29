package com.axis.service;

import java.math.BigDecimal;
import java.util.List;

import com.axis.entity.Transaction;

public interface TransactionService {

public double getAccountBalance(long customerId);

	public void performTransaction(long customerId, String transactionType,double amount, String beneficiaryAccountNumber,
			String narration);

	public List<Transaction> findByCustomerId(long customerId);
//	public	List<Transaction> findByTransactionNature( String transactionNature);
	public	List<Transaction> findByCustomerIdAndTransactionNature( long customerId,String transactionNature);
}
