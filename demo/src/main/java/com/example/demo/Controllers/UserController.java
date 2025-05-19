package com.example.demo.Controllers;

import com.example.demo.Services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@RestController
@RequestMapping("/auth")
public class UserController {
    @Autowired
    private TransactionService transactionService;
    private static final Logger logger= LoggerFactory.getLogger( UserController.class);

    @GetMapping("/users")
    public ResponseEntity<?>  getUsers(){
        logger.info("fetching all users");
        return ResponseEntity.ok(transactionService.getAllDetails());
    }
}
