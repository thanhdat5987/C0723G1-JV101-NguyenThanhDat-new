package com.example.bai_thi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PictureType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int typeId;
    private String typeName;
    @OneToMany(mappedBy = "pictureType")
    private Set<Picture> pictureSet;
}
