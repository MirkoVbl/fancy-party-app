package com.example.backend.controller;

import com.example.backend.model.Punishment;
import com.example.backend.repository.PunishmentRepo;
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
class PunishmentControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private PunishmentRepo repo;

    @MockBean
    private IdService idService;

    @DirtiesContext
    @Test
    void getAllPunishments() throws Exception {
        //Given
        Punishment dummyPunishment = new Punishment("1","Trinke etwas");
        Punishment dummyPunishment2 = new Punishment("2","Trinke einen Shot");
        repo.save(dummyPunishment);
        repo.save(dummyPunishment2);

        //When & Then
        mockMvc.perform(
                        get("/api/punishments"))
                .andExpect(status().is(200))
                .andExpect(content().string("""
                        [{"id":"1","punishmentText":"Trinke etwas"},{"id":"2","punishmentText":"Trinke einen Shot"}]"""));
    }


    @DirtiesContext
    @Test
    void createPunishment() throws Exception {
        //Given
        when(idService.generateId()).thenReturn("1");

        //WHEN & Then
        mockMvc.perform(
                        post("/api/punishments")
                                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                                .content("""
                                {"punishmentText":"Trinke etwas"}"""))
                .andExpect(status().is(200))
                .andExpect(content().string("""
                        {"id":"1","punishmentText":"Trinke etwas"}"""));
    }
}