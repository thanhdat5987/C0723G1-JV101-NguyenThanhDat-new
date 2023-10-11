package de_mo.thuc_hanh_mvc2.service.Impl;

import de_mo.thuc_hanh_mvc2.model.Book;
import de_mo.thuc_hanh_mvc2.repository.IBookRepository;
import de_mo.thuc_hanh_mvc2.repository.Impl.BookRepositoryImpl;
import de_mo.thuc_hanh_mvc2.service.IBookService;

import java.util.List;

public class BookServiceImpl implements IBookService {
   private static final IBookRepository bookRepository = new BookRepositoryImpl();

    @Override
    public void createBook(Book book) {
        bookRepository.createBook(book);

    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }

    @Override
    public void sortByName() {
        bookRepository.sortByName();
    }
}
