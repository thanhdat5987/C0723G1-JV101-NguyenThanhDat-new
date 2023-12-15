package com.example.bai_thi.controller;

import com.example.bai_thi.model.Student;
import com.example.bai_thi.service.IClassService;
import com.example.bai_thi.service.IStudentService;
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
    @Autowired
    private IClassService classService;
    @GetMapping("")
    public String showList(@RequestParam(defaultValue = "") String searchName , @RequestParam(defaultValue = "0") int page, Model model){
        Pageable pageable = PageRequest.of(page,2, Sort.by("name").ascending());
        Page<Student> studentPage = studentService.findAndSearch(searchName, pageable);
        model.addAttribute("studentPage", studentPage);
        model.addAttribute("searchName",searchName);
        return "/list";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam int id){
        studentService.remove(id);
        return "redirect:/";
    }
    @GetMapping("/details")
    public String showDetail(@RequestParam int id, Model model){
       Student student = studentService.findById(id);
        model.addAttribute("student", student);
        return "/details";
    }
    @GetMapping("/create")
    public String showAddForm(Model model){
        model.addAttribute("student", new Student());
        model.addAttribute("classLsit", classService.findAllClass());
        return "create";
    }
    @GetMapping("/edit")
    public String showEditForm(@RequestParam int id, Model model){
        Student student = studentService.findById(id);
        model.addAttribute("student", student);
        model.addAttribute("classList", classService.findAllClass());
        return "edit";
    }
}
