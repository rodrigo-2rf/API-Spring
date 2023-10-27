package com.example.app.entity;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class AvaliacaoCurso {
    
    @EmbeddedId
    private AvaliacaoCursoKey id = new AvaliacaoCursoKey();

    @ManyToOne
    @MapsId("colaboradorId")
    @JoinColumn(name = "colaborador_id")
    Colaborador colaborador;

    @ManyToOne
    @MapsId("cursoId")
    @JoinColumn(name = "curso_id")
    Curso curso;

    int nota;
}
