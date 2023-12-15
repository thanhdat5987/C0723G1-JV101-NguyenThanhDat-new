package com.example.quan_ly_heo.service.impl;

import com.example.quan_ly_heo.model.Heo;
import com.example.quan_ly_heo.repository.IHeoRepository;
import com.example.quan_ly_heo.service.IHeoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class HeoService implements IHeoService {
    @Autowired
    private IHeoRepository heoRepository;

    @Override
    public Page<Heo> findAllHeo(String maHeo, Pageable pageable) {
        return heoRepository.search("%"+maHeo+"%", pageable);
    }

    @Override
    public Heo findById(int id) {
        return heoRepository.findById(id).get();
    }

    @Override
    public void addHeo(Heo heo) {
        heoRepository.save(heo);
    }

    @Override
    public void removeHeo(int id) {
        heoRepository.deleteById(id);
    }
}
