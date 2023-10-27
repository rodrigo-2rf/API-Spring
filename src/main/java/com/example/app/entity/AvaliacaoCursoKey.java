package com.example.app.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class AvaliacaoCursoKey implements Serializable{
    
    private static final Long  serialVersionUIP = 1L;
    
    @Column(name = "colaborador_id")
    Long colaboradorId;
    

    @Column(name = "curso_id")
    Long cursoId;
}
