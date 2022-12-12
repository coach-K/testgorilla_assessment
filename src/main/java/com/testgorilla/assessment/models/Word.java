package com.testgorilla.assessment.models;

import org.hibernate.event.internal.ProxyVisitor;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String word1;
    private String word2;
    private String relation;
    

    protected Word() {
    }

    public Word(String word1, String word2, String relation) {
        this.word1 = word1;
        this.word2 = word2;
        this.relation = relation;
    }

    @Override
    public String toString() {
        return "Word [id=" + id + ", word1=" + word1 + ", word2=" + word2 + ", relation=" + relation + "]";
    }

    public Long getId() {
        return id;
    }

    public String getWord1() {
        return word1;
    }

    public String getWord2() {
        return word2;
    }

    public String getRelation() {
        return relation;
    }

    

    
}
