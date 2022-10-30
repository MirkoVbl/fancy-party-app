package com.example.backend.controller;


import com.example.backend.model.Player;
import com.example.backend.model.PlayerDTO;
import com.example.backend.service.FancyPartyAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fancypartyapp")
public class FancyPartyAppController {

    private final FancyPartyAppService fancyPartyAppService;

    @Autowired
    public FancyPartyAppController(FancyPartyAppService fancyPartyAppService) {
        this.fancyPartyAppService = fancyPartyAppService;
    }

    @GetMapping
    public List<Player> getAllPlayer() {
        return fancyPartyAppService.getAllPlayer();
    }

    @GetMapping("{id}")
    public Player getPlayer(@PathVariable String id){
        return fancyPartyAppService.getPlayer(id);
    }

    @PostMapping
    Player addPlayer(@RequestBody PlayerDTO addPlayer) {
        return fancyPartyAppService.addPlayer(addPlayer);
    }

    @DeleteMapping("{id}")
    public void deletePlayer(@PathVariable String id){
        fancyPartyAppService.deletePlayer(id);
    }
}
