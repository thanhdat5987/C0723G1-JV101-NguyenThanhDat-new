package com.example.blog_application.service;

import com.example.blog_application.model.Blog;
import com.example.blog_application.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    void addBlog(Blog blog);

    Blog findById(int id);

    void remove(int id);

    Page<Blog> findAllPage(String name, Pageable pageable);
    Page<Blog> searchBlogByNameAndCategory(String name,int categoryId, Pageable pageable);
    Page<Blog> showByCategory(int categoryId, Pageable pageable);

}
