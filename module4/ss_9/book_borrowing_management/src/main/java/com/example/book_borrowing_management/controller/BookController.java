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
    public String showList(Model model){
        List<Book> bookList = bookService.findAll();
        model.addAttribute("bookList", bookList);
        return "/list";
    }
    @GetMapping("/details")
    public String showDetails(@RequestParam int id, Model model) {
        model.addAttribute("book", bookService.findById(id));
        model.addAttribute("borrowInformation",new BorrowInformation());
        return "/details";
    }
    @PostMapping("/borrow")
    public String borrow(Book book, BorrowInformation borrowInformation,RedirectAttributes redirectAttributes){
        borrowInformation.setBook(book);
        borrowInformation.setStatus(1);
        borrowInformation.setBorrowCode((int)Math.floor(Math.random())*1000000);
        System.out.println(borrowInformation.getBorrowCode());
        borrowInformationService.add(borrowInformation);
        redirectAttributes.addFlashAttribute("code", borrowInformation.getBorrowCode());
        return "redirect:/result";
    }
}
