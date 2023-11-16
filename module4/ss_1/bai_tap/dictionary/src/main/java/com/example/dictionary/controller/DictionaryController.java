package com.example.dictionary.controller;

import com.example.dictionary.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    @Autowired
    private IDictionaryService dictionaryService;

    @GetMapping("/")
    public String showForm() {
        return "/dictionary";
    }

    @PostMapping("/")
    public String translate(@RequestParam String searchingWord, Model model) {
        String result = dictionaryService.translate(searchingWord);
        model.addAttribute("result", "Result is: " + result);
        return "/dictionary";
    }
}
