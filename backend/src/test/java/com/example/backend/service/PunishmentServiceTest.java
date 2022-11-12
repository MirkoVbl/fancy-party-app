package com.example.backend.service;

import com.example.backend.model.Punishment;
import com.example.backend.model.PunishmentDTO;
import com.example.backend.repository.PunishmentRepo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class PunishmentServiceTest {


    private final PunishmentRepo repo = mock(PunishmentRepo.class);
    private final IdService idService = mock(IdService.class);
    private final PunishmentService service = new PunishmentService(repo, idService);

    @Test
    void getAllPunishments() {
        //Given
        Punishment dummyPunishment = new Punishment("1", "Trink etwas");
        Punishment dummyPunishment2 = new Punishment("2", "Trinke einen Shot");

        when(repo.findAll()).thenReturn(List.of(dummyPunishment, dummyPunishment2));

        //When
        List<Punishment> actual = service.getAllPunishments();

        //Then
        List<Punishment> expected = List.of(dummyPunishment, dummyPunishment2);
        assertEquals (expected, actual);
    }

    @Test
    void createPunishment() {
        //Given
        PunishmentDTO dummyPunishmentDTO = new PunishmentDTO("Trink etwas");
        when(idService.generateId()).thenReturn("1");
        when(repo.save(any())).thenReturn(
                Punishment.builder()
                        .id("1")
                        .punishmentText(dummyPunishmentDTO.getPunishmentText())
                        .build()
        );

        //When
        Punishment actual = service.createPunishment(dummyPunishmentDTO);

        //Then
        Punishment expected = new Punishment("1", "Trink etwas");
        assertEquals(expected, actual);
    }

    @Test
    void getRandomPunishment() {
        //Given
        Punishment dummyPunishment = new Punishment("1", "wie gehts?");
        Punishment dummyPunishment2 = new Punishment("2", "was geht?");
        Punishment dummyPunishment3 = new Punishment("3", "was geht ab?");
        repo.save(dummyPunishment);
        repo.save(dummyPunishment2);
        repo.save(dummyPunishment3);
            when(repo.findRandom()).thenReturn(List.of(dummyPunishment2, dummyPunishment, dummyPunishment3));

        //When
        Punishment actual = service.getRandomPunishment();

        //Then
        assertEquals(dummyPunishment2, actual);
    }
}