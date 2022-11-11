package com.example.backend.service;

import com.example.backend.model.Question;
import com.example.backend.model.QuestionDTO;
import com.example.backend.repository.QuestionRepo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class QuestionServiceTest {

    private final QuestionRepo repo = mock(QuestionRepo.class);
    private final IdService idService = mock(IdService.class);
    private final QuestionService service = new QuestionService(repo, idService);

    @Test
    void getAllQuestions() {
        //Given
        Question dummyQuestion = new Question("1", "wie gehts?");
        Question dummyQuestion2 = new Question("2", "was geht?");

        when(repo.findAll()).thenReturn(List.of(dummyQuestion, dummyQuestion2));

        //When
        List<Question> actual = service.getAllQuestions();

        //Then
        List<Question> expected = List.of(dummyQuestion, dummyQuestion2);
        assertEquals (expected, actual);
    }

    @Test
    void createQuestion() {
        //Given
        QuestionDTO dummyQuestionDTO = new QuestionDTO("wie gehts?");
        when(idService.generateId()).thenReturn("1");
        when(repo.save(any())).thenReturn(
                Question.builder()
                        .id("1")
                        .questionText(dummyQuestionDTO.getQuestionText())
                        .build()
        );

        //When
        Question actual = service.createQuestion(dummyQuestionDTO);

        //Then
        Question expected = new Question("1", "wie gehts?");
        assertEquals(expected, actual);
    }

    @Test
    void getRandomQuestion() {
        //Given
        Question dummyQuestion = new Question("1", "wie gehts?");
        Question dummyQuestion2 = new Question("2", "was geht?");
        Question dummyQuestion3 = new Question("3", "was geht ab?");
        repo.save(dummyQuestion);
        repo.save(dummyQuestion2);
        repo.save(dummyQuestion3);
        when(repo.findRandom()).thenReturn(List.of(dummyQuestion2, dummyQuestion, dummyQuestion3));

        //When
        Question actual = service.getRandomQuestion();

        //Then
        assertEquals(dummyQuestion2, actual);

    }
}