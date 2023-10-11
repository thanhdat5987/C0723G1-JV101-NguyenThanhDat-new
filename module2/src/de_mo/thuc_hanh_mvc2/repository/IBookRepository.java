package de_mo.thuc_hanh_mvc2.repository;

import de_mo.thuc_hanh_mvc2.model.Book;

import java.util.List;

public interface IBookRepository {
    void createBook(Book book);
    List<Book> getAllBooks();
    void sortByName();
}
