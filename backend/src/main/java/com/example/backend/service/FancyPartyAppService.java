package com.example.backend.service;

import com.example.backend.model.FancyPartyApp;
import com.example.backend.repository.FancyPartyAppRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FancyPartyAppService {


    private final FancyPartyAppRepo fancyPartyAppRepo;
    private final IdService idService;

    @Autowired
    public FancyPartyAppService(FancyPartyAppRepo fancyPartyAppRepo, IdService idService) {
        this.fancyPartyAppRepo = fancyPartyAppRepo;
        this.idService = idService;


    }

    public List<FancyPartyApp> getAllPlayer() {
        return fancyPartyAppRepo.findAll();
    }

    public FancyPartyApp addPlayer(FancyPartyApp addPlayer) {
        addPlayer.setId(idService.generateId());

        return fancyPartyAppRepo.save(addPlayer);
    }
    public  void deletePlayer(String id) {fancyPartyAppRepo.deleteById(id);}


}
