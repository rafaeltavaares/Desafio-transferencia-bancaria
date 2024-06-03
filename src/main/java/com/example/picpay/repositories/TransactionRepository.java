package com.example.picpay.repositories;

import com.example.picpay.domain.transaction.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {

    List<Transaction> findTransactionBySender_id(Long id);

}
