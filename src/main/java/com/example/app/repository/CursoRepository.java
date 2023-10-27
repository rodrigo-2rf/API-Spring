package com.example.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.example.app.entity.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long>{
    Optional<Curso> findByNome(@Param("nome") String nome);
}