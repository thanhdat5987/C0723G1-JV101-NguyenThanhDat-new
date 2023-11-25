package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {
    @Autowired
   private IUserService userService;
    @GetMapping("/register")
    public String showRegisterForm(Model model){
        model.addAttribute("user", new User());
        return "/register";
    }
    @PostMapping("/save")
    public String register(@Validated User user, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "/register";
        }else {
            userService.addUser(user);
            model.addAttribute("user",user);
            return "/result";
        }
    }
}
