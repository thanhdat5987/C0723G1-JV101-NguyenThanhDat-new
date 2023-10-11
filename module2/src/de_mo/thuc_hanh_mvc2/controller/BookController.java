package de_mo.thuc_hanh_mvc2.controller;

import de_mo.thuc_hanh_mvc2.model.Book;
import de_mo.thuc_hanh_mvc2.service.IBookService;
import de_mo.thuc_hanh_mvc2.service.Impl.BookServiceImpl;

import java.util.List;

public class BookController {
    public static final IBookService bookService = new BookServiceImpl();

    public void createBook(Book book) {
        bookService.createBook(book);
    }

    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }
    public void sortByName(){
        bookService.sortByName();
    }
}
