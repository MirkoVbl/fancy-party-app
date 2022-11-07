package com.example.backend.controller;

import com.example.backend.model.Vote;
import com.example.backend.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/results")
public class ResultController {
    private final ResultService resultService;

    @Autowired
    public ResultController(ResultService resultService) {
        this.resultService = resultService;
    }

    @GetMapping("{questionId}")
    public List<Vote> allResultsForQuestion(@PathVariable String questionId){
        return resultService.allVotesForQuestion(questionId);
    }

    @DeleteMapping("{questionId}")
    public List<Vote> deleteVotesForQuestion(@PathVariable String questionId){
        return resultService.deleteVotesForQuestion(questionId);
    }
}
