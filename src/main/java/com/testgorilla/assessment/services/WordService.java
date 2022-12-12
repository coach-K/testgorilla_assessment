package com.testgorilla.assessment.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testgorilla.assessment.dao.WordRepository;
import com.testgorilla.assessment.models.Word;

@Service
public class WordService {

    private WordRepository repository;

    @Autowired
    public WordService(WordRepository repository) {
        this.repository = repository;
    }

    public List<Word> getAllWords() {
        List<Word> words = new ArrayList<>();
        this.repository.findAll().forEach(words::add);
        return words;
    }

    public Optional<Word> getWordById(long id) {
        return this.repository.findById(id); // this.repository.getWordById(id);
    }

    public Word save(Word word) {
        return this.repository.save(word);
    }

    public List<Word> findWordByRelation(String relation) {
        return this.repository.findWordByRelation(relation);
    }

    public Optional<Word> findWordByWord1AndWord2(String word1, String word2) {
        return this.repository.findWordByWord1AndWord2(word1, word2);
    }

    public List<Word> findWordByWord1AndRelationContains(String source, String target) {
        return this.repository.findWordByWord1ContainsAndRelationContains(source, target);
    }
    
}
