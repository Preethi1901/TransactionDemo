package com.example.demo.Models;

import jakarta.persistence.*;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;


@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer transactionId;
    private String cardNo;
    private String accountNo;
    private BigDecimal amount;
    private LocalDate date;
    private LocalTime time;
    private String atmId;
    private String atmLocation;
    private BigDecimal availableBalance; // Balance after transaction
    private String status;

    @PrePersist
    public void setDefaultDateTime(){
        if(this.date==null){
            this.date=LocalDate.now();
        }
        if(this.time==null){
            this.time=LocalTime.now();
        }
    }
    public Integer getTransactionId() {
        return transactionId;
    }
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getAtmId() {
        return atmId;
    }

    public void setAtmId(String atmId) {
        this.atmId = atmId;
    }

    public String getAtmLocation() {
        return atmLocation;
    }

    public void setAtmLocation(String atmLocation) {
        this.atmLocation = atmLocation;
    }

    public BigDecimal getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(BigDecimal availableBalance) {
        this.availableBalance = availableBalance;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}




