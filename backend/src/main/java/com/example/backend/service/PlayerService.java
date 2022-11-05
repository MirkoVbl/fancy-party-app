package com.example.backend.service;

import com.example.backend.model.Player;
import com.example.backend.model.PlayerDTO;
import com.example.backend.repository.PlayerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PlayerService {
    private final PlayerRepo playerRepo;
    private final IdService idService;

    @Autowired
    public PlayerService(PlayerRepo playerRepo, IdService idService) {
        this.playerRepo = playerRepo;
        this.idService = idService;
    }

    public List<Player> getAllPlayers() {
        return playerRepo.findAll();
    }

    public Player addPlayer(PlayerDTO addPlayer) {
        Player player = new Player();
        player.setId(idService.generateId());
        player.setPlayerName(addPlayer.getPlayerName());

        return playerRepo.save(player);
    }

    public  void deletePlayer(String id) {
        playerRepo.deleteById(id);
    }

    public Player getPlayer(String id){
        return playerRepo.findById(id)
                .orElseThrow(()-> new NoSuchElementException("Es konnte kein Spieler mit folgender ID gefunden werden:" +id));
    }
}
