package com.example.bai_thi.service.impl;

import com.example.bai_thi.model.PictureType;
import com.example.bai_thi.repository.IPictureTypeRepository;
import com.example.bai_thi.service.IPictureTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PictureTypeService implements IPictureTypeService {
    @Autowired
    private IPictureTypeRepository pictureTypeRepository;
    @Override
    public List<PictureType> findAllType() {
        return pictureTypeRepository.findAll();
    }
}
