package com.example.blog_application.repository;


import com.example.blog_application.model.Blog;
import com.example.blog_application.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    @Query(value = "select * from blog where name like:name ", nativeQuery = true)
    Page<Blog> search(@Param("name") String name, Pageable pageable);


    @Query(value = "SELECT * FROM blog where name like:name and category_id =:categoryId", nativeQuery = true)
    Page<Blog> searchBlogByNameAndCategory(@Param("name") String name, @Param("categoryId") int categoryId, Pageable pageable);

    @Query(value = "SELECT * FROM blog where category_id =:categoryId", nativeQuery = true)
    Page<Blog> showByCategory(@Param("categoryId") int categoryId, Pageable pageable);
}
