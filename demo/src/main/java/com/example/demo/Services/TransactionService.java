package com.example.demo.Services;

import com.example.demo.Models.Transaction;
import com.example.demo.Repositories.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Service
public class TransactionService {
    @Autowired
    private Repository repository;

    public List<Transaction> getAllDetails() {
    List<Transaction> transactions=new ArrayList<>();
    repository.findAll()
            .forEach(transactions ::add);


    return transactions;

    }

    public void addTransaction(Transaction transaction) {
        repository.save(transaction);

    }

    public List<Transaction> getTransactionsByCardNo(String cardNo) {

        return repository.findByCardNo(cardNo);
    }


    public List<Transaction> getTransactionsByDateTime(LocalDate date) {
        return repository.findByDate(date);
    }
    public List<Transaction> getTransactionBetweenDates(LocalDate startDate,LocalDate endDate){
        return repository.findByDateBetween(startDate, endDate);
    }

    public List<Transaction> getLocation(String location){
        return repository.findByAtmLocation(location);
    }

    private List<Transaction> getAtmId(String Id) {
        return repository.findByAtmId(Id);
    }

    public List<Transaction> getCardNoAndDate(String cardNo, LocalDate date) {
        return repository.findByCardNoAndDate(cardNo,date);
    }

    public List<Transaction> getTop10ByCardNoOrderByDateDesc(String cardNo){
        return repository.findTop10ByCardNoOrderByDateDesc(cardNo);
    }
    public Long getCountTransactionsByDate(LocalDate date){
        return repository.countTransactionsByDate(date);
    }

    public List<Object[]> getCountTransactions() {
        return repository.countTransactions();
    }

    public Page<Transaction> getAllTransactions(Pageable pageable){
        return repository.findAll(pageable);
    }

    public List<Object[]> getDailyAmount(){
        return repository.DailyAmount();
    }



}
