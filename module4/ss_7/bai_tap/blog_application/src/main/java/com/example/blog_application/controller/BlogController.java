package com.example.blog_application.controller;

import com.example.blog_application.model.Blog;
import com.example.blog_application.model.Category;
import com.example.blog_application.service.IBlogService;
import com.example.blog_application.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;
import java.util.List;

@RequestMapping("/blog")
@Controller
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
private ICategoryService categoryService;
    @GetMapping
    public String showList(Model model) {
        List<Blog> blogList = blogService.findAll();
        model.addAttribute("blogList", blogList);
        return "/blog/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id, RedirectAttributes attributes) {
        blogService.remove(id);
        attributes.addFlashAttribute("success", "Deleted successfully!");
        return "redirect:/blog";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("blog", new Blog());
        List<Category> categoryList = categoryService.findAllCategory();
        model.addAttribute("categoryList",categoryList);
        return "/blog/create";
    }

    @PostMapping("/save")
    public String save(Blog blog, RedirectAttributes attributes) {
        blogService.addBlog(blog);
        attributes.addFlashAttribute("success", "Added successfully!");
        return "redirect:/blog";
    }

    @GetMapping("/details")
    public String showDetails(@RequestParam int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "/blog/details";
    }

    @GetMapping("/edit")
    public String showUpdateForm(@RequestParam int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        List<Category> categoryList = categoryService.findAllCategory();
        model.addAttribute("categoryList",categoryList);
        return "/blog/update";
    }

    @PostMapping("/update")
    public String update(Blog blog) {
        blogService.addBlog(blog);
        return "redirect:/blog";
    }
}
