package com.example.demo.Services;

import com.example.demo.Models.Transaction;
import com.example.demo.Services.TransactionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
class TransactionServiceIntegrationTest {

    @Autowired
    private TransactionService transactionService;

    @Test
    void testGetAllDetailsWithRealDB() {
        List<Transaction> transactions = transactionService.getAllDetails();
        assertFalse(transactions.isEmpty());
    }
}
