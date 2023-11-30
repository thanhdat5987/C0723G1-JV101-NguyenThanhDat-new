package com.example.blog_application.service;

import com.example.blog_application.model.Blog;
import com.example.blog_application.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public void addBlog(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id).get();
    }

    @Override
    public void remove(int id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Page<Blog> findAllPage(String name, Pageable pageable) {
        return blogRepository.search("%" + name + "%", pageable);    }

    @Override
    public Page<Blog> searchBlogByNameAndCategory(String name, int categoryId, Pageable pageable) {
        return blogRepository.searchBlogByNameAndCategory(name,categoryId,pageable);
    }

    @Override
    public Page<Blog> showByCategory(int categoryId, Pageable pageable) {
        return blogRepository.showByCategory(categoryId,pageable);
    }
}
