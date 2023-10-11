package de_mo.thuc_hanh_mvc2.service;

import de_mo.thuc_hanh_mvc2.model.Book;

import java.util.List;

public interface IBookService {
    void createBook(Book book);
    List<Book> getAllBooks();
    void sortByName();
}
