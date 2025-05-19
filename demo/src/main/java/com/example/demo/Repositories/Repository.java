package com.example.demo.Repositories;

import com.example.demo.Models.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;

public interface Repository extends JpaRepository<Transaction,String> {
    List<Transaction> findByCardNo(String cardNo);


    List<Transaction> findByDate(LocalDate date);


    List<Transaction> findByDateBetween(LocalDate startDate,LocalDate endDate);


    List<Transaction> findByAtmLocation(String location);

    List<Transaction> findByAtmId(String atmId);


    @Query("select t  from Transaction t where t.cardNo= :cardNo and t.date= :date")
    List<Transaction> findByCardNoAndDate(@Param("cardNo") String cardNo, @Param("date") LocalDate date);

    List<Transaction> findTop10ByCardNoOrderByDateDesc(String cardNo);

    @Query("select count(t) from Transaction t where t.date=:date ")
    Long countTransactionsByDate(LocalDate date);

    @Query("select t.date, count(t) from Transaction t group by t.date order by t.date desc")
    List<Object[]> countTransactions();



    Page<Transaction> findAll(Pageable pageable);// this query internally is SELECT * FROM transactions LIMIT 10 OFFSET 0;

    @Query(value = "SELECT EXTRACT(MONTH FROM date) AS month, COUNT(*), SUM(amount) FROM transaction GROUP BY EXTRACT(MONTH FROM date)", nativeQuery = true)
   // @Query("select t.date, sum(t.amount)  from Transaction t group by t.date")
    List<Object[]> DailyAmount();
}
