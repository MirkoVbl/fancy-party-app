package com.example.backend.repository;

import com.example.backend.model.FancyPartyApp;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FancyPartyAppRepo extends MongoRepository<FancyPartyApp, String> {
}
