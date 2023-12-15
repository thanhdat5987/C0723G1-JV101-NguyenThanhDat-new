package com.example.quan_ly_heo.service;

import com.example.quan_ly_heo.model.Heo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IHeoService {
    Page<Heo> findAllHeo(String maHeo, Pageable pageable);
    Heo findById(int id);
    void addHeo(Heo heo);
    void removeHeo(int id);
}
