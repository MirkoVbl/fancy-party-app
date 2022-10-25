package com.example.backend.controller;

import com.example.backend.model.FancyPartyApp;
import com.example.backend.repository.FancyPartyAppRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class FancyPartyAppControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private FancyPartyAppRepo repo;


    @DirtiesContext
    @Test
    void getAllPlayer() throws Exception {
        //Given
        FancyPartyApp dummyFancyPartyApp = new FancyPartyApp("1","Spieler1");
        repo.save(dummyFancyPartyApp);

        //When & Then

        mockMvc.perform(
                        get("/api/fancypartyapp"))
                .andExpect(status().is(200))
                .andExpect(content().string("""
                        [{"id":"1","player":"Spieler1"}]"""));
    }
    @DirtiesContext
    @Test
    void getPlayer_whenPlayerNotExists_returns404() throws Exception {
        //Given

        //When & Then
        mockMvc.perform(
                        get("/api/fancypartyapp/1337"))
                .andExpect(status().is(404));
    }

}