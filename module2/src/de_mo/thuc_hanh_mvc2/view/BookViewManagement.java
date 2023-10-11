package de_mo.thuc_hanh_mvc2.view;

import de_mo.thuc_hanh_mvc2.controller.BookController;
import de_mo.thuc_hanh_mvc2.model.Book;
import de_mo.thuc_hanh_mvc2.util.Validation;

import java.util.List;
import java.util.Scanner;

public class BookViewManagement {
    private static final BookController bookController = new BookController();
    private static final Scanner scanner = new Scanner(System.in);

    public static void displayMenu() {
        int choice = 0;
        while (choice != 4) {
            try {
                System.out.println("===Menu===");
                System.out.println("Please enter your choice");
                System.out.println("1. Add book");
                System.out.println("2. Display books list");
                System.out.println("3. Sort Book by Name");
                System.out.println("4. Exit");
                System.out.println("Please enter your choice");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        addBook();
                        break;
                    case 2:
                        displayBooks();
                        break;
                    case 3:
                        sortBookByName();
                        break;
                    case 4:
                        System.exit(4);
                    default:
                        System.out.println("You need enter number form 1-4");
                }

            } catch (NumberFormatException e) {
                System.out.println(e.getMessage() + ", please enter number");
            }

        }
    }

    public static void addBook() {
        String newId = enterNewId();
        System.out.println("enter name of book");
        String bookName = scanner.nextLine();
        System.out.println("Enter book 's description");
        String bookDescription = scanner.nextLine();
        int bookPrice = enterBookPrice();
        Book newBook = new Book(newId, bookName, bookDescription, bookPrice);
        bookController.createBook(newBook);
    }

    public static void displayBooks() {
        List<Book> books = bookController.getAllBooks();
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public static void sortBookByName() {
        bookController.sortByName();
        displayBooks();
    }

    public static int getIndexById(String id) {
        List<Book> books = bookController.getAllBooks();
        int index = -1;
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId().equals(id)) {
                index = i;
            }
        }
        return index;
    }

    public static String enterNewId() {
        String newId;
        do {
            System.out.println("enter id");
            newId = scanner.nextLine();
            if (Validation.validateBookId(newId)) {
                if (getIndexById(newId) == -1) {
                    return newId;
                } else {
                    System.out.println("Id has been exist, please enter again");
                }
            } else {
                System.out.println("Please following format SA-xxxx, x is number 0-9");
            }
        } while (true);
    }

    public static int enterBookPrice() {
        int bookPrice;
        do {
            try {
                System.out.println("Enter price of book");
                bookPrice = Integer.parseInt(scanner.nextLine());
                return bookPrice;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage() + " please re-enter");
            }
        } while (true);
    }
}
