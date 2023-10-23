package com.example.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Gera GET e SET
@Getter @Setter
// Cria construtor com todos os argumentos
@AllArgsConstructor
// Cria construtor sem argumentos
@NoArgsConstructor
@Entity
public class Endereco {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String logradouro;
    private String bairro;
    private String cidade;
    private String cep;

    @OneToOne(mappedBy = "endereco")
    private Colaborador colaborador;
}