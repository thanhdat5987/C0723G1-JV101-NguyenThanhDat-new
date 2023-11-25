package com.example.song_management.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Length;

@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty
    @Size(max = 800)
    @Pattern(regexp = "^([a-zA-Z0-9]+)([a-zA-Z0-9 ]*)")
    private String name;
    @NotEmpty
    @Size(max = 300)
    @Pattern(regexp = "^([a-zA-Z0-9]+)([a-zA-Z0-9 ]*)")
    private String singer;
    @NotEmpty
    @Size(max = 1000)
    @Pattern(regexp = "^([a-zA-Z0-9,]+)([a-zA-Z0-9, ]*)")
    private String type;

    public Song() {
    }

    public Song(int id, String name, String singer, String type) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.type = type;
    }

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
}
