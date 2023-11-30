package com.example.blog_application.controller;

import com.example.blog_application.model.Blog;
import com.example.blog_application.model.Category;
import com.example.blog_application.service.CategoryService;
import com.example.blog_application.service.IBlogService;
import com.example.blog_application.service.ICategoryService;
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


import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@RequestMapping("/blog")
@Controller
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
private ICategoryService categoryService;
    @GetMapping
    public String showList(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "") String searchingName,@RequestParam(defaultValue = "0") int categoryId, Model model) {
        Pageable pageable = PageRequest.of(page,2, Sort.by("create_date").ascending());
        Category category = null;
        Page<Blog> blogList;
        if (categoryId == 0) {
            blogList = blogService.findAllPage(searchingName,pageable);
        } else {
            blogList = blogService.searchBlogByNameAndCategory(searchingName,categoryId, pageable);
            category = categoryService.getCategory(categoryId);
            System.out.println(category);
        }
        model.addAttribute("blogList", blogList);
        model.addAttribute("searchingName", searchingName);
        model.addAttribute("category",category);
        model.addAttribute("categoryList", categoryService.findAllCategory());
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
        blog.setCreateDate(LocalDateTime.now());
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
    @GetMapping("/showByCategory")
    public String showByCategory(){
        return "blog/list";
    }
}
