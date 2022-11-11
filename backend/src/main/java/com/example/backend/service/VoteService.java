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

        Vote vote = Vote.builder()
                        .id(idService.generateId())
                        .questionId(voteDTO.getQuestionId())
                        .answerId(voteDTO.getAnswerId())
                        .voterId(voteDTO.getVoterId()).build();
        return voteRepo.save(vote);
    }
}
