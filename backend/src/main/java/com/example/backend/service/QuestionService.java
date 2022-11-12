package com.example.backend.service;

import com.example.backend.model.Question;
import com.example.backend.model.QuestionDTO;
import com.example.backend.repository.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class QuestionService {
    private final QuestionRepo questionRepo;
    private final IdService idService;

    @Autowired
    public QuestionService(QuestionRepo questionRepo, IdService idService) {
        this.questionRepo = questionRepo;
        this.idService = idService;
    }

    public List<Question> getAllQuestions() {
        return questionRepo.findAll();
    }

    public Question createQuestion(QuestionDTO questionDTO){

        Question question = Question.builder()
                .id(idService.generateId())
                .questionText(questionDTO.getQuestionText()).build();
        return questionRepo.save(question);
    }

    public Question getRandomQuestion() {
        List<Question> randomQuestions = questionRepo.findRandom();
        if (randomQuestions.isEmpty()) {
            throw new NoSuchElementException("Keine Fragen vorhanden.");
        }
        return randomQuestions.get(0);
    }
}
