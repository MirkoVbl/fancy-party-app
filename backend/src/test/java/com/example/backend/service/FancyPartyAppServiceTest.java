package com.example.backend.service;

import com.example.backend.model.Player;
import com.example.backend.repository.FancyPartyAppRepo;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;

class FancyPartyAppServiceTest {

    private final FancyPartyAppRepo repo = mock(FancyPartyAppRepo.class);
    private final IdService idService = mock(IdService.class);
    private final FancyPartyAppService service = new FancyPartyAppService(repo, idService);


    @Test
    void getAllPlayers() {
        //Given
        when(repo.findAll())
                .thenReturn(List.of(
                        new Player("1337", "Spieler1"),
                        new Player("9000", "Spieler2"),
                        new Player("187", "Spieler3")));

        //When
        List<Player> actual = service.getAllPlayer();

        //Then
        List<Player> expected = List.of(
                new Player("1337", "Spieler1"),
                new Player("9000", "Spieler2"),
                new Player("187", "Spieler3"));
        verify(repo).findAll();
        assertEquals(expected, actual);
    }

    @Test
    void addPlayer() {
        //Given
        Player dummyPlayer = new Player(null, "Spieler1");
        when(repo.save(dummyPlayer)).thenReturn(dummyPlayer);

        //When
        Player actual = service.addPlayer(dummyPlayer);

        //Then
        verify(repo).save(dummyPlayer);
        assertEquals(dummyPlayer, actual);
    }

    @Test
    void deletePlayer() {
        //Given
        when(repo.findById("1337")).thenReturn(Optional.of(new Player("1447", "Spieler1")));

        //When
        service.deletePlayer("1337");

        //Then
        verify(repo).deleteById("1337");
    }

}
