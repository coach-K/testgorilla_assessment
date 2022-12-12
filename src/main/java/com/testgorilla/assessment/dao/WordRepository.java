package com.testgorilla.assessment.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.testgorilla.assessment.models.Word;

public interface WordRepository extends CrudRepository<Word, Long> {
    List<Word> findWordByRelation(String relation);

    Optional<Word> findWordByWord1AndWord2(String word1, String word2);

    List<Word> findWordByWord1Contains(String contain);

    List<Word> findWordByRelationContains(String contain);
}
