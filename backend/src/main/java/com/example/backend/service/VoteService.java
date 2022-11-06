package com.example.backend.service;

import com.example.backend.model.Vote;
import com.example.backend.model.VoteDTO;
import com.example.backend.repository.VoteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoteService {
    private final VoteRepo voteRepo;
    private final IdService idService;

    @Autowired
    public VoteService(VoteRepo voteRepo, IdService idService) {
        this.voteRepo = voteRepo;
        this.idService = idService;
    }

    public Vote createVote(VoteDTO voteDTO){

        Vote vote = new Vote();
        vote.setId(idService.generateId());
        vote.setVoterId(voteDTO.getVoterId());
        vote.setAnswerId(voteDTO.getAnswerId());
        vote.setQuestionId(voteDTO.getQuestionId());
        return voteRepo.save(vote);
    }
}
