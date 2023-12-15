package com.example.bai_thi.service.impl;

import com.example.bai_thi.model.Picture;
import com.example.bai_thi.repository.IPictureRepository;
import com.example.bai_thi.service.IPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PictureService implements IPictureService {
    @Autowired
    private IPictureRepository pictureRepository;

    @Override
    public Page<Picture> findAllPicture(String searchName, Pageable pageable) {
        return pictureRepository.search("%" + searchName + "%", pageable);
    }

    @Override
    public Picture findById(int id) {
        return pictureRepository.findById(id).get();
    }

    @Override
    public void add(Picture picture) {
        pictureRepository.save(picture);
    }

    @Override
    public void delete(int id) {
        pictureRepository.deleteById(id);
    }
}
