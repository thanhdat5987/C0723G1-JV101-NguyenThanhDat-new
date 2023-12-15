package com.example.bai_thi.controller;

import com.example.bai_thi.model.Picture;
import com.example.bai_thi.service.IPictureService;
import com.example.bai_thi.service.IPictureTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PictureController {
    @Autowired
    private IPictureService pictureService;
    @Autowired
    private IPictureTypeService pictureTypeService;

    @GetMapping("")
    public String showList(@RequestParam(defaultValue = "") String searchName, @RequestParam(defaultValue = "0") int page, Model model) {
        Pageable pageable = PageRequest.of(page, 10);
        Page<Picture> picturePage = pictureService.findAllPicture(searchName, pageable);
        model.addAttribute("picturePage", picturePage);
        model.addAttribute("searchName", searchName);
        return "/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("picture", new Picture());
        model.addAttribute("typeList", pictureTypeService.findAllType());
        return "/create";
    }

    @PostMapping("/save")
    public String save(Picture picture) {
        pictureService.add(picture);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id) {
        pictureService.delete(id);
        return "redirect:/";
    }
}
