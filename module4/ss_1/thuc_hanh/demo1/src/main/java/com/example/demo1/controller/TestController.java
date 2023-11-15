package com.example.demo1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {
    @GetMapping("/test")
    public String showForm(){
        return "/test";
    }
    @PostMapping("/test")
    public String sayHello(@RequestParam String enteringName, Model model){
        model.addAttribute("name", "Hello "+enteringName);
        return "/test";
    }
}
