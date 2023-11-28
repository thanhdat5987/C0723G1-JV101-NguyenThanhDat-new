package com.example.book_borrowing_management.repository;

import com.example.book_borrowing_management.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IBookRepository extends JpaRepository<Book,Integer> {
//    @Query(value = "update book set quantity =(quantity-1) where id =:id ", nativeQuery = true)
//    void borrow(@Param("id") int id);
}
