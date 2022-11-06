package com.example.backend.controller;

import com.example.backend.model.Vote;
import com.example.backend.model.VoteDTO;
import com.example.backend.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/votes")
public class VoteController {

    private final VoteService voteService;

    @Autowired
    public VoteController(VoteService voteService){
        this.voteService = voteService;
    }

    @PostMapping
    public Vote createVote(@RequestBody VoteDTO voteDTO){
        return voteService.createVote(voteDTO);
    }

    @GetMapping("byQuestionId")
    public List<Vote> allVotesForQuestion(@RequestParam String questionId){
        return voteService.allVotesForQuestion(questionId);
    }


}
