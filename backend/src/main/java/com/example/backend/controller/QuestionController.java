package com.example.backend.controller;

import com.example.backend.model.Question;
import com.example.backend.model.QuestionDTO;
import com.example.backend.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {

    private final QuestionService questionService;


    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @GetMapping("random")
    public Question getRandomQuestion() {
        return questionService.getRandomQuestion();
    }

    @PostMapping
    public Question createQuestion(@RequestBody QuestionDTO questionDTO){
        return questionService.createQuestion(questionDTO);
    }
}
