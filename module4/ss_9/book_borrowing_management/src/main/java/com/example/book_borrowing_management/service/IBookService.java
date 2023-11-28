package com.example.book_borrowing_management.service;

import com.example.book_borrowing_management.model.Book;

import java.util.List;


public interface IBookService {
    List<Book> findAll();
    Book findById(int id);
}
