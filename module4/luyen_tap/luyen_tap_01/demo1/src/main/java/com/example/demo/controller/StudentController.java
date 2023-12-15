package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class StudentController {
    @Autowired
    private IStudentService studentService;
    @GetMapping("")
    public String showList(@RequestParam(defaultValue = "") String searchName , @RequestParam(defaultValue = "0") int page, Model model){
        Pageable pageable = PageRequest.of(page,2, Sort.by("name").ascending());
        Page<Student> studentPage = studentService.findAndSearch(searchName, pageable);
        model.addAttribute("studentPage", studentPage);
        model.addAttribute("searchName",searchName);
        return "/list";
    }
}
