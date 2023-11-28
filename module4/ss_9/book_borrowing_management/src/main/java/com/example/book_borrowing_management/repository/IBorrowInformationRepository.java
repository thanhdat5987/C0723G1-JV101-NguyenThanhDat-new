package com.example.book_borrowing_management.repository;

import com.example.book_borrowing_management.model.BorrowInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBorrowInformationRepository extends JpaRepository<BorrowInformation, Integer> {
}
