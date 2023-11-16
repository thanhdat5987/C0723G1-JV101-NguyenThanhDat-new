package com.example.dictionary.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DictionaryRepository implements IDictionaryRepository {
    private static Map<String, String> dictionary = new HashMap<>();

    static {
        dictionary.put("hello", "Xin chào");
        dictionary.put("how", "Thế nào");
        dictionary.put("book", "Quyển vở");
        dictionary.put("computer", "Máy tính");
        dictionary.put("love", "Yêu");
        dictionary.put("hi", "Chào");
    }

    public Map<String, String> getAll() {
        return dictionary;
    }

    public String translate(String word) {
        Map<String, String> dictionaryMap = DictionaryRepository.dictionary;
        String result;
        word = word.toLowerCase().trim();
        result = dictionaryMap.get(word);
        if (result == null) {
            result = "Couldn't find";
        }
        return result;
    }
}
