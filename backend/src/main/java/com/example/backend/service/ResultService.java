package com.example.backend.service;

import com.example.backend.model.Vote;
import com.example.backend.repository.VoteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultService {
    private final VoteRepo voteRepo;

    @Autowired
    public ResultService(VoteRepo voteRepo) {
        this.voteRepo = voteRepo;
    }

    public List<Vote> allVotesForQuestion(String questionId){
        return voteRepo.findVotesByQuestionId(questionId);
    }

    public List<Vote> deleteVotesForQuestion(String questionId){
        return voteRepo.deleteVotesByQuestionId(questionId);
    }

}
