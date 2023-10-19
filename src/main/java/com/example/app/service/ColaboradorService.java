package com.example.app.service;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.app.entity.Colaborador;
import com.example.app.repository.ColaboradorRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ColaboradorService {  
    
    // necessário fazer a injeção de dependências
    private ColaboradorRepository colaboradorRepository;
    
    public ResponseEntity<Colaborador> buscarColaboradorPorId(Long id){
        if(colaboradorRepository.existsById(id)){
            return ResponseEntity.status(HttpStatus.OK).body(colaboradorRepository.findById(id).get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    public List<Colaborador> buscarTodosColaboradores(){
        return colaboradorRepository.findAll();
    }

    public ResponseEntity<Colaborador> cadastrarColaborador(Colaborador colaborador){
        Colaborador colaboradoresSalvo = colaboradorRepository.save(colaborador);
        return ResponseEntity.status(HttpStatus.CREATED).body(colaboradoresSalvo);
    }

    public ResponseEntity<Colaborador> atualizarColaborador(Long id, Colaborador colaborador){
        if(colaboradorRepository.existsById(id)){
            Colaborador colaboradoresSalvo = colaboradorRepository.save(colaborador);
            return ResponseEntity.status(HttpStatus.CREATED).body(colaboradoresSalvo);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        
    }

    public ResponseEntity<String> removerEstudante(Long id){
        if(colaboradorRepository.existsById(id)){
            colaboradorRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Colaborador deletado");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Estudante não encontrado");
    }
}