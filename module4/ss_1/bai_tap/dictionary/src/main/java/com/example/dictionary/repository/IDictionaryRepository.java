package com.example.dictionary.repository;

import java.util.Map;

public interface IDictionaryRepository {
    Map<String, String> getAll();

    String translate(String word);
}
