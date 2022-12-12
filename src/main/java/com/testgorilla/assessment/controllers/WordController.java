package com.testgorilla.assessment.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.testgorilla.assessment.models.Word;
import com.testgorilla.assessment.services.WordService;

@RestController
@RequestMapping(path = "/words")
public class WordController {

    public WordService service;

    @Autowired
    public WordController(WordService service) {
        this.service = service;
    }

    @PostMapping
    public Word postWord(@RequestBody Word word) {
        return this.service.save(word);
    }

    @GetMapping
    public List<Word> getAllWords() {
        return this.service.getAllWords();
    }

    @GetMapping(params = "relation")
    public List<Word> getAllWords(@RequestParam("relation") String relation) {
        return this.service.findWordByRelation(relation);
    }
    
}
