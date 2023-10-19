package com.example.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.app.entity.Colaborador;

public interface ColaboradorRepository extends JpaRepository<Colaborador, Long>{
    
}
