package com.example.backend.service;

import com.example.backend.model.Punishment;
import com.example.backend.model.PunishmentDTO;
import com.example.backend.repository.PunishmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PunishmentService {
    private final PunishmentRepo punishmentRepo;
    private final IdService idService;

    @Autowired
    public PunishmentService(PunishmentRepo punishmentRepo, IdService idService) {
        this.punishmentRepo = punishmentRepo;
        this.idService = idService;
    }

    public List<Punishment> getAllPunishments(){
        return punishmentRepo.findAll();
    }

        public Punishment createPunishment(PunishmentDTO punishmentDTO){

        Punishment punishment = new Punishment();
        punishment.setId(idService.generateId());
        punishment.setPunishmentText(punishmentDTO.getPunishmentText());
        return punishmentRepo.save(punishment);
    }
    public Punishment getRandomPunishment(){
        List<Punishment> randomPunishment = punishmentRepo.findRandom();
        if (randomPunishment.isEmpty()){
            throw new NoSuchElementException("Keine Strafen vorhanden");
        }
        return randomPunishment.get(0);
    }
}
