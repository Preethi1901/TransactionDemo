package com.example.demo.Services;

import com.example.demo.Models.Transaction;
import com.example.demo.Repositories.Repository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TransactionServiceTest {

    @Mock
    private Repository repository;

    @InjectMocks
    private TransactionService transactionService;

    @BeforeAll                      //excuted only once thats why static method-uses for db connection
    public static void sample(){
        System.out.println("before all");
    }
    @BeforeEach
    public  void sample1(){                 //here no static method
        System.out.println("before each");
    }

    @Test
    void testGetAllDetails_EmptyList() {

        Transaction t1=new Transaction();
        t1.setAtmLocation("MGRoad, Bangalore");
        t1.setAtmId("ATM001");

        Transaction t2=new Transaction();
        t2.setAtmLocation("Hyderabad");
        t2.setAtmId("ATM002");

        List<Transaction> mockResult=List.of(t1,t2);
        System.out.println(mockResult);

        when(repository.findAll()).thenReturn(List.of(t1,t2));
        List<Transaction> res=transactionService.getAllDetails();

        //assertTrue(res.isEmpty());
        assertEquals("MGRoad, Bangalore", res.get(0).getAtmLocation());
        assertTrue(t1.getAtmLocation()=="MGRoad, Bangalore");

        //System.out.println("executed");
    }




}