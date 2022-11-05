package com.example.backend.controller;

import com.example.backend.model.Player;
import com.example.backend.model.PlayerDTO;
import com.example.backend.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerController {
    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @GetMapping("{id}")
    public Player getPlayer(@PathVariable String id){
        return playerService.getPlayer(id);
    }

    @PostMapping
    Player addPlayer(@RequestBody PlayerDTO addPlayer) {
        return playerService.addPlayer(addPlayer);
    }

    @DeleteMapping("{id}")
    public void deletePlayer(@PathVariable String id){
        playerService.deletePlayer(id);
    }
}
