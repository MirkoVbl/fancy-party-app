package com.example.backend.controller;

import com.example.backend.model.Player;
import com.example.backend.repository.FancyPartyAppRepo;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class FancyPartyAppControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private FancyPartyAppRepo repo;

    @MockBean
    private IdService idService;



    @DirtiesContext
    @Test
    void getAllPlayer() throws Exception {
        //Given
        Player dummyPlayer = new Player("1","Spieler1");
        repo.save(dummyPlayer);

        //When & Then

        mockMvc.perform(
                        get("/api/fancypartyapp"))
                .andExpect(status().is(200))
                .andExpect(content().string("""
                        [{"id":"1","playerName":"Spieler1"}]"""));
    }

    @DirtiesContext
    @Test
    void getPlayer_whenPlayerNotExists_returns404() throws Exception {
        //Given

        //When & Then
        mockMvc.perform(
                        get("/api/fancypartyapp/1337/abc"))
                .andExpect(status().is(404));
    }

    @DirtiesContext
    @Test
    void createPlayer() throws Exception {
        //Given
        when(idService.generateId()).thenReturn("1337");

        //When & Then
        mockMvc.perform(
                        post("/api/fancypartyapp")
                                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                                .content("""
                                    {"playerName":"Spieler1"}"""))
                .andExpect(status().is(200))
                .andExpect(content().string("""
                        {"id":"1337","playerName":"Spieler1"}"""));
    }

    @DirtiesContext
    @Test
    void createPlayer_whenMissingName_returns400() throws Exception {
        //Given
        when(idService.generateId()).thenReturn("1337");

        //When & Then
        mockMvc.perform(
                        post("/api/fancypartyapp")
                                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                                .content("""
                                    {""}"""))
                .andExpect(status().is(400));
    }

    @DirtiesContext
    @Test
    void deletePlayer() throws Exception {
        //Given
        Player dummyPlayer = new Player("1337", "Spieler1");
        repo.save(dummyPlayer);

        //When & Then
        mockMvc.perform(delete("/api/fancypartyapp/1337"))
                .andExpect(status().is(200));
    }



}