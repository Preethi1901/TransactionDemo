package com.example.demo.Controllers;

import com.example.demo.Models.Transaction;
import com.example.demo.Services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/auth")
public class Controller {
    @Autowired
    private TransactionService service;

    @GetMapping("/get")
    public List<Transaction> getDetails(){

        return service.getAllDetails();

    }

    @PostMapping("/post")
    public void postDetails(@RequestBody Transaction transaction) {
        service.addTransaction(transaction);
    }

//    @GetMapping("/getByCardNo/{cardNo}")
//    public List<Transaction> getTransactionsByCardNo(@PathVariable String cardNo) {
//        return service.getTransactionsByCardNo(cardNo);
//    }
    @GetMapping("/getByCardNo")
    public List<Transaction> getTransactionsByCardNo(@RequestParam String cardNo) {
        return service.getTransactionsByCardNo(cardNo);
    }

    @GetMapping("/getByDate/{date}")
    private List<Transaction> getByDate(@PathVariable LocalDate date){
        return service.getTransactionsByDateTime(date);
    }

//    @GetMapping("/betweenDate/{startDate}/{endDate}")
//    public List<Transaction> getByDateBetween(@PathVariable LocalDate startDate,@PathVariable LocalDate endDate){
////        LocalDate start=LocalDate.parse(startDate);
////        LocalDate end=LocalDate.parse(endDate);
//
//
//        return service.getTransactionBetweenDates(startDate , endDate);
//    }

    @GetMapping("/betweenDate")

    public List<Transaction> getByDateBetween(@RequestParam LocalDate startDate,@RequestParam  LocalDate endDate){
//        LocalDate start=LocalDate.parse(startDate);
//        LocalDate end=LocalDate.parse(endDate);


        return service.getTransactionBetweenDates(startDate , endDate);
    }
    @GetMapping("/getByLocation")
    public List<Transaction> getByLocation(@RequestParam String location){
        return service.getLocation(location);
    }

    @GetMapping("/getByAtmId")
    public List<Transaction> getAtmId(@RequestParam String Id){
        return service.getAtmId(Id);
    }

    @GetMapping("/getByCardAndDate")
    public List<Transaction> getByCardNoAndDate(@RequestParam String cardNo, @RequestParam LocalDate date){
        return service.getCardNoAndDate(cardNo, date);
    }
    @GetMapping("/getTop10ByCardNoOrderByDateDesc")
    public List<Transaction> getTop10ByCardNoOrderByDateDesc(@RequestParam String cardNo){
        return service.getTop10ByCardNoOrderByDateDesc(cardNo);
    }

    @GetMapping("/getCountByDate")
    public Long getCount(@RequestParam LocalDate date){
        return service.getCountTransactionsByDate(date);
    }
    @GetMapping("/getCount")
    public List<Object[]> getCount(){
        return service.getCountTransactions();
    }

    @GetMapping("/transactions")
    public Page<Transaction> getPaginatedTransactions(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        //Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "amount"));
        Pageable pageable = PageRequest.of(page, size, Sort.by("amount"));
        return service.getAllTransactions(pageable);
    }

    @GetMapping("/dailyAmount")
    public List<Object[]> getDailyAmount(){
        return service.getDailyAmount();
    }







}
