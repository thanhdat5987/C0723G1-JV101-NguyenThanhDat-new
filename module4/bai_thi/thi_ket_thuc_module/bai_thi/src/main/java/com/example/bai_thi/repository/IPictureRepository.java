package com.example.bai_thi.repository;

import com.example.bai_thi.model.Picture;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IPictureRepository extends JpaRepository<Picture, Integer> {
    @Query(value = "select * from picture where name like:name",nativeQuery = true)
    Page<Picture> search(@Param("name") String name, Pageable pageable);
}
