package com.example.book_borrowing_management.controller;

import com.example.book_borrowing_management.model.Book;
import com.example.book_borrowing_management.model.BorrowInformation;
import com.example.book_borrowing_management.service.IBookService;
import com.example.book_borrowing_management.service.IBorrowInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private IBookService bookService;
    @Autowired
    private IBorrowInformationService borrowInformationService;

    @GetMapping("/list")
    public String showList(Model model) {
        List<Book> bookList = bookService.findAll();
        model.addAttribute("bookList", bookList);
        return "/list";
    }

    @GetMapping("/details")
    public String showDetails(@RequestParam int id, Model model) {
        model.addAttribute("book", bookService.findById(id));
        return "/details";
    }

    @GetMapping("/borrow")
    public String borrow(int id, Model model, RedirectAttributes redirectAttributes) {
        BorrowInformation borrowInformation = new BorrowInformation();
        Book book = bookService.findById(id);
        borrowInformation.setBook(book);
        borrowInformation.setStatus(1);
        borrowInformation.setBorrowCode((int) (Math.random() * 100000));
        borrowInformationService.add(borrowInformation);
        book.setQuantity(book.getQuantity() - 1);
        bookService.update(book);
        redirectAttributes.addFlashAttribute("name", book.getName());
        redirectAttributes.addFlashAttribute("borrowCode", borrowInformation.getBorrowCode());
        return "redirect:/result";
    }

    @GetMapping("/result")
    public String showResult() {
        return "/result";
    }

    @GetMapping("/return")
    public String showReturnForm() {
        return "/return";
    }

    @PostMapping("/return")
    public String returnBook(@RequestParam("borrowCode") int borrowCode, RedirectAttributes redirectAttributes) {
        BorrowInformation borrowInformation = borrowInformationService.checkBorrowCode(borrowCode);
        if (borrowInformation == null) {
            redirectAttributes.addFlashAttribute("result", "Can't find the borrow Code");
        } else {
            borrowInformation.setStatus(0);
            borrowInformationService.update(borrowInformation);
            Book book = borrowInformation.getBook();
            book.setQuantity(book.getQuantity() + 1);
            bookService.update(book);
            redirectAttributes.addFlashAttribute("result", "Return Book successfully!");

        }
        return "redirect:/list";
    }

}
