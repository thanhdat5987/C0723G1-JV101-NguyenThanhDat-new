package com.example.book_borrowing_management.controller;

import com.example.book_borrowing_management.model.Book;
import com.example.book_borrowing_management.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private IBookService bookService;
    @GetMapping("/list")
    public String showList(Model model){
        List<Book> bookList = bookService.findAll();
        model.addAttribute("bookList", bookList);
        return "/list";
    }
    @GetMapping("/details")
    public String showDetails(@RequestParam int id, Model model) {
        model.addAttribute("book", bookService.findById(id));
        return "/details";
    }
}
