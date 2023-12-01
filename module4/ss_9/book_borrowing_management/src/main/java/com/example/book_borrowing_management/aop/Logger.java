package com.example.book_borrowing_management.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
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

    @After("execution(* com.example.book_borrowing_management.controller.BookController.borrow(..))")
    public void borrowHistory(JoinPoint joinPoint) {
        Object[] object = joinPoint.getArgs();
        int id = (int) object[0];
        System.out.println("Book borrow id: " + id);
    }
    @After("execution(* com.example.book_borrowing_management.controller.BookController.returnBook(..))")
    public void returnHistory(JoinPoint joinPoint) {
        Object[] object = joinPoint.getArgs();
        int code = (int) object[0];
        System.out.println("Book return code is: " + code);
    }
}