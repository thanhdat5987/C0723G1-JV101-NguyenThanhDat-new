package com.example.quan_ly_heo.controller;

import com.example.quan_ly_heo.model.Heo;
import com.example.quan_ly_heo.service.IHeoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@RequestMapping("/heo")
@Controller
public class HeoController {
    @Autowired
    private IHeoService heoService;
    @GetMapping("")
    public String showList(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "") String searchCode, Model model){
        Pageable pageable = PageRequest.of(page, 2);
        Page<Heo> listHeo = heoService.findAllHeo(searchCode, pageable);
        model.addAttribute("listHeo", listHeo);
        model.addAttribute("searchCode", searchCode);
        return "heo/list";
    }
}
