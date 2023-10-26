package com.example.app.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.entity.Colaborador;
import com.example.app.entity.Curso;
import com.example.app.service.CursoService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("cursos")
@AllArgsConstructor
public class CursoController {

    // usou a anotação AllArgsConstructor para a injeção de dependência
    private CursoService cursoService;

    @GetMapping("/{id}")
    public ResponseEntity<Curso> buscarCursoPorId(@PathVariable Long id){
        return cursoService.buscarCursoPorId(id);
    }

    @GetMapping
    public List<Curso> buscarTodosCursos(){
        return cursoService.buscarCursos();
    }

    @PostMapping
    public ResponseEntity<Curso> cadastrarCurso(@RequestBody Curso curso){
        return cursoService.cadastrarCurso(curso);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curso> atualizarCurso(@PathVariable Long id, @RequestBody Curso curso){
        return cursoService.atualizarCurso(id, curso);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removerCurso(@PathVariable Long id){
        return cursoService.removerCurso(id);
    }

}
