package com.example.backend.controller;

import com.example.backend.model.Vote;
import com.example.backend.repository.VoteRepo;
import com.example.backend.service.ResultService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class ResultControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private VoteRepo repo;

    @MockBean
    private ResultService service;


    @Test
    void allResultsForQuestion() throws Exception {
        //Given
        Vote dummyVote = new Vote("1", "Player1", "q1", "Player2");
        Vote dummyVote2 = new Vote("2", "Player2", "q1", "Player1");
        Vote dummyVote3 = new Vote("3", "Player3", "q2", "Player2");
        repo.save(dummyVote);
        repo.save(dummyVote2);
        repo.save(dummyVote3);
        when(service.allVotesForQuestion(any())).thenReturn(List.of(dummyVote, dummyVote2));

        String expectedJson = """
                [
                    {
                        "id": "1",
                        "voterId": "Player1",
                        "questionId": "q1",
                        "answerId": "Player2"
                    },
                    {
                        "id": "2",
                        "voterId": "Player2",
                        "questionId": "q1",
                        "answerId": "Player1"
                    }
                ]
                """;

        mockMvc.perform(get("/api/results/" + "q1"))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJson));
    }

    @Test
    void deleteVotesForQuestion() throws Exception {
        //Given
        Vote dummyVote = new Vote("1", "Player1", "q1", "Player2");
        Vote dummyVote2 = new Vote("2", "Player2", "q1", "Player1");
        Vote dummyVote3 = new Vote("3", "Player3", "q2", "Player2");
        repo.save(dummyVote);
        repo.save(dummyVote2);
        repo.save(dummyVote3);
        when(service.deleteVotesForQuestion(any())).thenReturn(List.of(dummyVote3));

        String expectedJson = """
                [
                    {
                        "id": "3",
                        "voterId": "Player3",
                        "questionId": "q2",
                        "answerId": "Player2"
                    }
                ]
                """;

        mockMvc.perform(delete("/api/results/" + "q1"))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJson));

    }
}