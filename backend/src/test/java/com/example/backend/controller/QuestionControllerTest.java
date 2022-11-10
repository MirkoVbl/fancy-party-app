package com.example.backend.controller;

import com.example.backend.model.Player;
import com.example.backend.model.Question;
import com.example.backend.repository.QuestionRepo;
import com.example.backend.service.IdService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;




@SpringBootTest
@AutoConfigureMockMvc
class QuestionControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private QuestionRepo repo;

    @MockBean
    private IdService idService;

    @DirtiesContext
    @Test
    void getAllQuestions() throws Exception{
        //Given
        Question dummyQuestion = new Question("1337","Wer ist am sportlichsten?");
        repo.save(dummyQuestion);

        //When & Then
        mockMvc.perform(
                        get("/api/questions"))
                .andExpect(status().is(200))
                .andExpect(content().string("""
                        [{"id":"1337","questionText":"Wer ist am sportlichsten?"}]"""));
    }


    @DirtiesContext
    @Test
    void getQuestion_whenQuestionNotExists_returns404() throws Exception {
        //Given

        //When & Then
        mockMvc.perform(
                        get("/api/questions/1337/abc"))
                .andExpect(status().is(404));
    }

    @DirtiesContext
    @Test
    void createQuestion() throws  Exception{
        //Given
        when(idService.generateId()).thenReturn("1337");

        //WHEN & Then
        mockMvc.perform(
                        post("/api/questions")
                                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                                .content("""
                                {"questionText":"Wer ist am sportlichsten?"}"""))
                .andExpect(status().is(200))
                .andExpect(content().string("""
                        {"id":"1337","questionText":"Wer ist am sportlichsten?"}"""));
    }
    @DirtiesContext
    @Test
    void createPlayer_whenMissingName_returns400() throws Exception {
        //Given
        when(idService.generateId()).thenReturn("1337");

        //When & Then
        mockMvc.perform(
                        post("/api/questions")
                                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                                .content("""
                                    {""}"""))
                .andExpect(status().is(400));
    }
}