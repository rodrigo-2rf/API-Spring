package com.example.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.app.entity.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{
    
}