package com.example.calculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @GetMapping("/")
    public String showIndex() {
        return "/index";
    }

    @PostMapping("/calculate")
    public String calculate(@RequestParam("operator") String operator, @RequestParam double number1, @RequestParam double number2, Model model) {
        String result = "";
        switch (operator) {
            case "+":
                result = String.valueOf(number1 + number2);
                break;
            case "-":
                result = String.valueOf(number1 - number2);
                break;
            case "*":
                result = String.valueOf(number1 * number2);
                break;
            case "/":
                if (number2 != 0) {
                    result = String.valueOf(number1 / number2);
                } else {
                    result = "Couldn't divide zero";
                }
                break;
        }
        model.addAttribute("result", "The result is " + result);
        return "/index";
    }
}
