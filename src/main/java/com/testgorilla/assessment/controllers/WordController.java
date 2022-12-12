package com.testgorilla.assessment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
    
}
