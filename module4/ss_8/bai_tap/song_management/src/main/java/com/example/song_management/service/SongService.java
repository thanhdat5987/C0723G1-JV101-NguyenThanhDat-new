package com.example.song_management.service;

import com.example.song_management.model.Song;
import com.example.song_management.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService implements ISongService {
    @Autowired
    private ISongRepository songRepository;

    @Override
    public List<Song> getAll() {
        return songRepository.findAll();
    }

    @Override
    public Song findById(int id) {
        return songRepository.findById(id).get();
    }

    @Override
    public void add(Song song) {
        songRepository.save(song);
    }

}
