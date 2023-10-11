package de_mo.thuc_hanh_mvc2.repository.Impl;

import de_mo.thuc_hanh_mvc2.model.Book;
import de_mo.thuc_hanh_mvc2.repository.IBookRepository;
import de_mo.thuc_hanh_mvc2.service.IBookService;
import de_mo.thuc_hanh_mvc2.util.FileUtil;

import java.util.ArrayList;
import java.util.List;

public class BookRepositoryImpl implements IBookRepository {
    private static final String BOOK_LIST_PATH = "/Users/thaodao/Thanh Dat/GitHub/Codegym/C0723G1-JV101-NguyenThanhDat-new/module2/src/de_mo/thuc_hanh_mvc2/data/book.csv";

    @Override
    public void createBook(Book book) {
        List<Book> books = readBooksFromFile();
        books.add(book);
        writeBooksToFile(books);

    }

    @Override
    public List<Book> getAllBooks() {
        return readBooksFromFile();
    }

    @Override
    public void sortByName() {
        List<Book> books = readBooksFromFile();
        Book temp;
        for (int i = 0; i < books.size() - 1; i++) {
            for (int j = i + 1; j < books.size(); j++) {
                if(books.get(i).getName().compareTo(books.get(j).getName())>0){
                    temp = books.get(i);
                    books.set(i, books.get(j));
                    books.set(j,temp);
                }
            }
        }
        writeBooksToFile(books);
    }

    public static List<Book> readBooksFromFile() {
        List<String> data = FileUtil.readFile(BOOK_LIST_PATH);
        List<Book> books = new ArrayList<>();
        for (String str : data) {
            String[] splitedString = str.split(",");
            books.add(new Book(splitedString[0], splitedString[1], splitedString[2], Integer.parseInt(splitedString[3])));
        }
        return books;
    }

    public static void writeBooksToFile(List<Book> books) {
        List<String> data = new ArrayList<>();
        for (Book book : books) {
            data.add(book.getId() + "," + book.getName() + "," + book.getType() + "," + book.getPrice());
        }
        FileUtil.writeFile(data, BOOK_LIST_PATH);
    }
}
