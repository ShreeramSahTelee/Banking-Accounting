package com.axis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.axis.entity.Transaction;
import com.axis.service.TransactionService;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @GetMapping("/balance")
    public ResponseEntity<Double> getAccountBalance(@RequestParam long customerId) {
        double balance = transactionService.getAccountBalance(customerId);
        return ResponseEntity.ok(balance);
    }

    @PostMapping("/perform")
    public ResponseEntity<String> performTransaction(@RequestBody Transaction transaction) {
        transactionService.performTransaction(
                transaction.getCustomerId(),
                transaction.getTransactionType(),
               
                transaction.getAmount(),
                transaction.getBeneficiaryAccountNumber(),
                transaction.getNarration()
        );
        return ResponseEntity.ok("Transaction successful");
    }
    
    @GetMapping("/transactionByCustomerId/{customerId}")
    public ResponseEntity<List<Transaction>> getTransactionByCustomerId(@PathVariable long customerId){
    	return new ResponseEntity<List<Transaction>>(transactionService.findByCustomerId(customerId),HttpStatus.OK);
    }
    
//    @GetMapping("/transactionByTransactionNature/{transactionNature}")
//    public ResponseEntity<List<Transaction>> getTransactionByNature(@PathVariable String transactionNature){
//    	return new ResponseEntity<List<Transaction>>(transactionService.findByTransactionNature(transactionNature),HttpStatus.OK);
//    }
    
    
    @GetMapping("/transactionByTransactionNature/{customerId}/{transactionNature}")
    public ResponseEntity<List<Transaction>> getTransactionListByTransactionNature(@PathVariable  long customerId,String transactionNature){
    	return new ResponseEntity<List<Transaction>>(transactionService.findByCustomerIdAndTransactionNature(customerId,transactionNature),HttpStatus.OK);
    }
    
        
}