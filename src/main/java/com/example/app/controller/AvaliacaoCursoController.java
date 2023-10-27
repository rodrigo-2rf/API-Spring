package com.example.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.service.AvaliacaoCursoService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/avaliacoes")
public class AvaliacaoCursoController {

    private final AvaliacaoCursoService avaliacaoService;

    @PostMapping
    public ResponseEntity<String> avaliar(
        @RequestParam Long idColaborador,
        @RequestParam String nome,
        @RequestParam Integer notaAvaliacao){
            return avaliacaoService.avaliar(idColaborador, nome, notaAvaliacao);
    }
}