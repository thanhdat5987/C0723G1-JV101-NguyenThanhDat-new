package com.example.book_borrowing_management.aop;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {
    static int count = 0;

    @After("execution(* com.example.book_borrowing_management.controller.BookController.*(..))")
    public void countUser() {
        count++;
        System.out.println("Number of user visited " + count);
    }
}