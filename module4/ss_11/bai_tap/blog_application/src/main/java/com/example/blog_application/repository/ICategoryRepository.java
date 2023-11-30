package com.example.blog_application.repository;

import com.example.blog_application.model.Blog;
import com.example.blog_application.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Integer> {
}
