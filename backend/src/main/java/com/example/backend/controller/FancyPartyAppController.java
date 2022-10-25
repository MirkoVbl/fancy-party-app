package com.example.backend.controller;


import com.example.backend.model.FancyPartyApp;
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
    public List<FancyPartyApp> getAllPlayer() {
        return fancyPartyAppService.getAllPlayer();
    }

    @PostMapping
    FancyPartyApp addPlayer(@RequestBody FancyPartyApp addPlayer) {
        return fancyPartyAppService.addPlayer(addPlayer);
    }
}