package com.testgorilla.assessment.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.testgorilla.assessment.models.CustomError;
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
    public ResponseEntity postWord(@RequestBody Word word) throws Exception {
        //Check if string match regex a-zA-Z
        if (!word.getWord1().matches("[a-zA-Z\\s]*") 
        || !word.getWord2().matches("[a-zA-Z\\s]*")
        || !word.getRelation().matches("[a-zA-Z\\s]*")) {
            return new ResponseEntity<>(new CustomError("Words cannot contain special characters or numeric"), HttpStatus.BAD_REQUEST);
        }
        Word newWord = new Word(
            word.getWord1().toLowerCase().trim(), 
            word.getWord2().toLowerCase().trim(), 
            word.getRelation().toLowerCase().trim()
            );
        return new ResponseEntity<>(this.service.save(newWord), HttpStatus.OK);
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
