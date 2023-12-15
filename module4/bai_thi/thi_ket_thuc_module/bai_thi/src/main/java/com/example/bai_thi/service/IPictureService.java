package com.example.bai_thi.service;

import com.example.bai_thi.model.Picture;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPictureService {
    Page<Picture> findAllPicture(String searchName, Pageable pageable);
    Picture findById(int id);
    void add(Picture picture);
    void delete(int id);
}
