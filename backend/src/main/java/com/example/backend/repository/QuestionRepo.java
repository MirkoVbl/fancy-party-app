package com.example.backend.repository;

import com.example.backend.model.Question;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepo extends MongoRepository<Question, String> {
    @Aggregation(pipeline = {
        "{'$sample': {'size': 1}}"
    })
    List<Question> findRandom();
}
