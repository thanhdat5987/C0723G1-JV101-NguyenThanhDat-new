package com.example.song_management.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class SongDto implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String singer;

    private String type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public SongDto() {
    }

    public SongDto(int id, String name, String singer, String type) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.type = type;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        SongDto songDto = (SongDto) target;
        if ("".equals(songDto.getName())) {
            errors.rejectValue("name", null, "Yeu cau nhap");
        } else if (!songDto.getName().matches("^([a-zA-Z0-9]+)([a-zA-Z0-9 ]*)")) {
            errors.rejectValue("name", null, "chua dung dinh dang");
        }

        if ("".equals(songDto.getSinger())) {
            errors.rejectValue("singer", null, "Yeu cau nhap");
        } else if (!songDto.getName().matches("^([a-zA-Z0-9]+)([a-zA-Z0-9 ]*)")) {
            errors.rejectValue("singer", null, "chua dung dinh dang");
        }

        if ("".equals(songDto.getName())) {
            errors.rejectValue("type", null, "Yeu cau nhap");
        } else if (!songDto.getName().matches("^([a-zA-Z0-9]+)([a-zA-Z0-9 ]*)")) {
            errors.rejectValue("type", null, "chua dung dinh dang");
        }
    }
}
