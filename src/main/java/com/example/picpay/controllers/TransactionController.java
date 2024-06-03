package com.example.picpay.controllers;

import com.example.picpay.DTOs.TransactionDTO;
import com.example.picpay.domain.transaction.Transaction;
import com.example.picpay.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;


    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody TransactionDTO data) throws Exception {
        Transaction transaction = this.transactionService.createTransaction(data);
        return new ResponseEntity<>(transaction, HttpStatus.OK);
    }
    @GetMapping("/{accountID}/transaction")
    public ResponseEntity<List<Transaction> > getTransaction(@PathVariable Long accountID) throws Exception {
        List<Transaction> transaction = this.transactionService.findTransaction(accountID);
        return new ResponseEntity<>(transaction,HttpStatus.OK);
    }
}
