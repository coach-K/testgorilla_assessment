package com.testgorilla.assessment.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.testgorilla.assessment.models.Word;

public interface WordRepository extends CrudRepository<Word, Long> {
    List<Word> findWordByRelation(String relation);
}
