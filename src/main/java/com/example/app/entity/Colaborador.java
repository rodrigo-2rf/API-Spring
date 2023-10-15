package com.example.app.entity;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Colaborador {
    
    private Long id;
    private String nome;
    private String email;
    private LocalDate dataNascimento;

}