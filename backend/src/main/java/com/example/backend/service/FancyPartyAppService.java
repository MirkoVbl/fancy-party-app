package com.example.backend.service;

import com.example.backend.model.Player;
import com.example.backend.repository.FancyPartyAppRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class FancyPartyAppService {


    private final FancyPartyAppRepo fancyPartyAppRepo;
    private final IdService idService;

    @Autowired
    public FancyPartyAppService(FancyPartyAppRepo fancyPartyAppRepo, IdService idService) {
        this.fancyPartyAppRepo = fancyPartyAppRepo;
        this.idService = idService;
    }

    public List<Player> getAllPlayer() {
        return fancyPartyAppRepo.findAll();
    }

    public Player addPlayer(Player addPlayer) {
        addPlayer.setId(idService.generateId());

        return fancyPartyAppRepo.save(addPlayer);
    }

    public  void deletePlayer(String id) {fancyPartyAppRepo.deleteById(id);}

    public Player getPlayer(String id){
        return fancyPartyAppRepo.findById(id)
                .orElseThrow(()-> new NoSuchElementException("Es könnte kein Spieler mit folgender ID gefunden werden:" +id));
    }
}
