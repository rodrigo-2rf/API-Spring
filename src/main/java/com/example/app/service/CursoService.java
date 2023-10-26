package com.example.app.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.app.entity.Curso;
import com.example.app.repository.CursoRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CursoService {

    private CursoRepository cursoRepository;

    public ResponseEntity<Curso> buscarCursoPorId(Long id){
        if(cursoRepository.existsById(id)){
            return ResponseEntity.status(HttpStatus.OK).body(cursoRepository.findById(id).get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    public List<Curso> buscarCursos(){
        return cursoRepository.findAll();
    }

    // cadastrar
    public ResponseEntity<Curso> cadastrarCurso(Curso curso){
        Curso cursosSalvo = cursoRepository.save(curso);
        return ResponseEntity.status(HttpStatus.CREATED).body(cursosSalvo);
    }

    // editar
    public ResponseEntity<Curso> atualizarCurso(Long id, Curso curso){
        if(cursoRepository.existsById(id)){
            curso.setId(id);
            Curso cursosSalvo = cursoRepository.save(curso);
            return ResponseEntity.status(HttpStatus.CREATED).body(cursosSalvo);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    // excluir
    public ResponseEntity<String> removerCurso(Long id){
        if(cursoRepository.existsById(id)){
            cursoRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Curso deletado");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Curso não encontrado");
    }
    
}
