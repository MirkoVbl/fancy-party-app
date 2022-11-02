package com.example.backend.controller;


import com.example.backend.model.Punishment;
import com.example.backend.model.PunishmentDTO;
import com.example.backend.service.PunishmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/punishments")
public class PunishmentController {

    private final PunishmentService punishmentService;

    @Autowired
    public PunishmentController(PunishmentService punishmentService) {
        this.punishmentService = punishmentService;
    }
    @GetMapping
    public List<Punishment> getAllPunishments(){
        return punishmentService.getAllPunishments();
    }
    @GetMapping("random")
    public Punishment getRandomPunishment(){
        return punishmentService.getRandomPunishment();
    }

    @PostMapping
    public Punishment createPunishment(@RequestBody PunishmentDTO punishmentDTO){
        return punishmentService.createPunishment(punishmentDTO);
    }
}
