package com.example.sandwich.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller
public class SandwichController {
    @GetMapping("/")
    public String showIndex(){
        return "/index";
    }
    @PostMapping("/save")
    public String save(@RequestParam("condiment") String[] condiment, Model model){
        model.addAttribute("condimentList","You have chosen: "+Arrays.toString(condiment));
        return "/index";
    }
}
