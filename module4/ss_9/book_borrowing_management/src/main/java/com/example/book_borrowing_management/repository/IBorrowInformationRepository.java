package com.example.book_borrowing_management.repository;

import com.example.book_borrowing_management.model.BorrowInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IBorrowInformationRepository extends JpaRepository<BorrowInformation, Integer> {
    @Query(value = "select * from borrow_information where borrow_code = :code and status = 1", nativeQuery = true)
    BorrowInformation checkBorrowCode(@Param("code") int code);
}
