package com.example.song_management.service;

import com.example.song_management.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> getAll();

    Song findById(int id);

    void add(Song song);
}
