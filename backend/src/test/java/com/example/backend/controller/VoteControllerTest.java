package com.example.backend.controller;

import com.example.backend.service.IdService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class VoteControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private IdService idService;


    @Test
    void createVote() throws Exception {
        //Given
        when(idService.generateId()).thenReturn("1");

        //WHEN & Then
        mockMvc.perform(
                        post("/api/votes")
                                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                                .content("""
                                {"id": "1","voterId": "Player1","questionId": "q1","answerId": "Player2"}"""))
                .andExpect(status().is(200))
                .andExpect(content().string("""
                        {"id":"1","voterId":"Player1","questionId":"q1","answerId":"Player2"}"""));
    }
}