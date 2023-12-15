package com.example.quan_ly_heo.repository;

import com.example.quan_ly_heo.model.Heo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IHeoRepository extends JpaRepository<Heo, Integer> {
@Query(value = "select * from heo where ma_heo like:maHeo", nativeQuery = true)
    Page<Heo> search(@Param("maHeo") String maHeo, Pageable pageable);
}
