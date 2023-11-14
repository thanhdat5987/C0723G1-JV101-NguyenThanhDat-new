package com.example.currency_conversion.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyConversionController {
    @GetMapping("/currency_conversion")
    public String showForm() {
        return "/currency_conversion";
    }

    @PostMapping("/currency_conversion")
    public String currencyConversion(@RequestParam float rate, @RequestParam float usdAmount, Model model) {
        float result = rate * usdAmount;
        model.addAttribute("result", result);
        return "/currency_conversion";
    }
}
