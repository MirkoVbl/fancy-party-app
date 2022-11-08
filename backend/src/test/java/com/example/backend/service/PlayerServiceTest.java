package com.example.backend.service;

import com.example.backend.model.Player;
import com.example.backend.model.PlayerDTO;
import com.example.backend.repository.PlayerRepo;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class PlayerServiceTest {

    private final PlayerRepo repo = mock(PlayerRepo.class);
    private final IdService idService = mock(IdService.class);
    private final PlayerService service = new PlayerService(repo, idService);

    @Test
    void getAllPlayers() {
        //Given
        when(repo.findAll())
                .thenReturn(List.of(
                        new Player("1337", "Spieler1"),
                        new Player("9000", "Spieler2"),
                        new Player("187", "Spieler3")));

        //When
        List<Player> actual = service.getAllPlayers();

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
        Player playerToAdd = Player.builder().playerName("Spieler1").build();
        when(repo.save(playerToAdd)).thenReturn(Player.builder().id("1337").playerName("Spieler1").build());


        //When
        PlayerDTO newPlayer = PlayerDTO.builder().playerName("Spieler1").build();
        Player actual = service.addPlayer(newPlayer);

        //Then
        Player expected = Player.builder().id("1337").playerName("Spieler1").build();
        verify(repo).save(playerToAdd);
        assertEquals(expected, actual);
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