package com.example.book_borrowing_management.service;

import com.example.book_borrowing_management.model.BorrowInformation;
import com.example.book_borrowing_management.repository.IBookRepository;
import com.example.book_borrowing_management.repository.IBorrowInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BorrowInformationService implements IBorrowInformationService{
    @Autowired
   private IBorrowInformationRepository borrowInformationRepository;
    @Override
    public void add(BorrowInformation borrowInformation) {
        borrowInformationRepository.save(borrowInformation);
    }

    @Override
    public BorrowInformation checkBorrowCode(int code) {
        return borrowInformationRepository.checkBorrowCode(code);
    }

    @Override
    public void update(BorrowInformation borrowInformation) {
        borrowInformationRepository.save(borrowInformation);
    }
}
