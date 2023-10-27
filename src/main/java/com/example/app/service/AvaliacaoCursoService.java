package com.example.app.service;

import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.app.controller.ColaboradorController;
import com.example.app.entity.AvaliacaoCurso;
import com.example.app.entity.Colaborador;
import com.example.app.entity.Curso;
import com.example.app.repository.AvaliacaoCursoRepository;
import com.example.app.repository.ColaboradorRepository;
import com.example.app.repository.CursoRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AvaliacaoCursoService {

    private final AvaliacaoCursoRepository avaliacaoRepository;
    private final ColaboradorRepository colaboradorRepository;
    private final CursoRepository cursoRepository;

    public ResponseEntity<String> avaliar(Long idColaborador, String nomeCurso, Integer notaAvaliacao){
        Optional<Colaborador> colaboradorOpt = colaboradorRepository.findById(idColaborador);
        if(!colaboradorOpt.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Colaborador nao encontrado");
        }

        Optional<Curso> cursoOpt = cursoRepository.findByNome(nomeCurso);
        if(!cursoOpt.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Curso nao encontrado");
        }

        AvaliacaoCurso avaliacaoCurso = new AvaliacaoCurso();
        avaliacaoCurso.setColaborador(colaboradorOpt.get());
        avaliacaoCurso.setCurso(cursoOpt.get());
        avaliacaoCurso.setNota(notaAvaliacao);

        avaliacaoRepository.save(avaliacaoCurso);
        return ResponseEntity.ok("Avaliacao salva com sucesso");
    }

    
}
