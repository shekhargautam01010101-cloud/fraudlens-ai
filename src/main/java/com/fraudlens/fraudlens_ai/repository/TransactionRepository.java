package com.fraudlens.fraudlens_ai.repository;

import com.fraudlens.fraudlens_ai.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}