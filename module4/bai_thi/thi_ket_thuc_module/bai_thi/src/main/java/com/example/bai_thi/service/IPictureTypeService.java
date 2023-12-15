package com.example.bai_thi.service;

import com.example.bai_thi.model.PictureType;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IPictureTypeService {
    List<PictureType> findAllType();
}
