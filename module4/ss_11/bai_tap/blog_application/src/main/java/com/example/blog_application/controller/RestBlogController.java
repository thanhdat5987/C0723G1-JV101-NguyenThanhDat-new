package com.example.blog_application.controller;

import com.example.blog_application.model.Blog;
import com.example.blog_application.model.Category;
import com.example.blog_application.service.IBlogService;
import com.example.blog_application.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api-blogs")
public class RestBlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public ResponseEntity<Page<Blog>> getList(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "") String searchingName) {
        Pageable pageable = PageRequest.of(page, 2, Sort.by("create_date").ascending());
        Page<Blog> blogPage = blogService.findAllPage(searchingName, pageable);
        if (blogPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogPage, HttpStatus.OK);
    }

    @GetMapping("/category")
    public ResponseEntity<List<Category>> getListCategory() {
        List<Category> categoryList = categoryService.findAllCategory();
        if (categoryList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBlog(@PathVariable int id) {
        Blog blog = blogService.findById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }
    @GetMapping("/blog/{id}")
    public ResponseEntity<Page<Blog>> getListByCategory(@RequestParam(defaultValue = "0") int page, @PathVariable int id) {
        Pageable pageable = PageRequest.of(page, 2, Sort.by("create_date").ascending());
        Page<Blog> blogPage = blogService.showByCategory(id, pageable);
        if (blogPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogPage, HttpStatus.OK);
    }
}
