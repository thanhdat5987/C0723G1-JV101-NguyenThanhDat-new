package com.example.blog_application.service;

import com.example.blog_application.model.Blog;
import com.example.blog_application.model.Category;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    void addBlog(Blog blog);

    Blog findById(int id);

    void remove(int id);


}
