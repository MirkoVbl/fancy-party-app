package com.example.backend.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;



@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerDTO {
    private String playerName;
}