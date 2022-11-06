package com.example.backend.repository;

import com.example.backend.model.Vote;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface VoteRepo extends MongoRepository<Vote, String> {
    @Query("{'questionId' : ?0}")
    List<Vote> findVotesByQuestionId(String questionId);

    @Query(value="{'questionId' : ?0}", delete = true)
    List<Vote> deleteVotesByQuestionId(String questionId);
}
