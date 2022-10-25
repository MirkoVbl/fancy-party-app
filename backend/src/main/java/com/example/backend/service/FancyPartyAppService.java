package com.example.backend.service;

import com.example.backend.model.FancyPartyApp;
import com.example.backend.repository.FancyPartyAppRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FancyPartyAppService {


    private final FancyPartyAppRepo fancyPartyAppRepo;
    private final  IdService idService;

    @Autowired
    public FancyPartyAppService(FancyPartyAppRepo fancyPartyAppRepo, IdService idService) {
        this.fancyPartyAppRepo = fancyPartyAppRepo;
        this.idService = idService;


    }

    public List<FancyPartyApp> getAllPlayer() {
        return fancyPartyAppRepo.findAll();
    }

    public FancyPartyApp addPlayer(FancyPartyApp addPlayer) {
        FancyPartyApp newPlayer = FancyPartyApp.builder()
                .id(idService.generateId())
                .player(addPlayer.getPlayer())
                .build();

        return fancyPartyAppRepo.save(newPlayer);
    }


}
