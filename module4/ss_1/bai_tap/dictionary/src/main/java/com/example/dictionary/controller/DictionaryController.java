package com.example.dictionary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DictionaryController {
    @GetMapping("/")
    public String showForm() {
        return "/dictionary";
    }

    @PostMapping("/")
    public String translate(@RequestParam String searchingWord, Model model) {
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("hello", "Xin chào");
        dictionary.put("how", "Thế nào");
        dictionary.put("book", "Quyển vở");
        dictionary.put("computer", "Máy tính");
        dictionary.put("love", "Yêu");
        dictionary.put("hi", "Chào");
        String result = dictionary.get(searchingWord);
        if (result != null) {
            model.addAttribute("result", result);
        } else {
            model.addAttribute("result", "Couldn't find");
        }
        return "/dictionary";
    }
}
