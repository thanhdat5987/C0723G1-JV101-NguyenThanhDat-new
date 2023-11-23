package com.example.blog_application.repository;


import com.example.blog_application.model.Blog;
import com.example.blog_application.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
}
