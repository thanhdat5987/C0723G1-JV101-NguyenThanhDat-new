package com.example.book_borrowing_management.service;

import com.example.book_borrowing_management.model.BorrowInformation;

public interface IBorrowInformationService {
    void add(BorrowInformation borrowInformation);
    BorrowInformation checkBorrowCode(int code);
    void update(BorrowInformation borrowInformation);
}
