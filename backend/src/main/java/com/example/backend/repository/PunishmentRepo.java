package com.example.backend.repository;

import com.example.backend.model.Punishment;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PunishmentRepo extends MongoRepository<Punishment, String> {
    @Aggregation(pipeline = {
            "{'$sample': {'size': 1}}"
    })
    List<Punishment> findRandom();
}
