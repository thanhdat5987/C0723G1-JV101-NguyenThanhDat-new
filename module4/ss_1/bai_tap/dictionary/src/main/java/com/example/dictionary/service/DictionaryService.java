package com.example.dictionary.service;

import com.example.dictionary.repository.IDictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class DictionaryService implements IDictionaryService {
    @Autowired
    private IDictionaryRepository dictionaryRepository;

    @Override
    public Map<String, String> getAll() {
        return dictionaryRepository.getAll();
    }

    @Override
    public String translate(String word) {
        return dictionaryRepository.translate(word);
    }
}
