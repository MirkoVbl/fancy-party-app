package com.example.backend.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("players")
public class Player {

    @Id
    private String id;
    private String playerName;
}
