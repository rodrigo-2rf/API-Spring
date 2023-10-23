package com.example.app.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.app.entity.Colaborador;
import com.example.app.entity.Livro;
import com.example.app.repository.ColaboradorRepository;
import com.example.app.repository.LivroRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ColaboradorService {  
    
    // necessário fazer a injeção de dependências
    private ColaboradorRepository colaboradorRepository;
    private LivroRepository livroRepository;
    
    public ResponseEntity<Colaborador> buscarColaboradorPorId(Long id){
        if(colaboradorRepository.existsById(id)){
            return ResponseEntity.status(HttpStatus.OK).body(colaboradorRepository.findById(id).get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    // public List<Colaborador> buscarTodosColaboradores(){
    //     return colaboradorRepository.findAll();
    // }
    public Page<Colaborador> buscarTodosColaboradores(PageRequest page){
        return colaboradorRepository.findAll(page);
    }

    public ResponseEntity<Colaborador> cadastrarColaborador(Colaborador colaborador){
        
        // Salvar livros
        Set<Livro> livros = colaborador.getLivros();
        colaborador.setLivros(new HashSet<>());
        Colaborador colaboradoresSalvo = colaboradorRepository.save(colaborador);
        for (Livro livro : livros){
            livro.setColaborador(Colaborador.builder().id(colaborador.getId()).build());
            colaborador.getLivros().add(livroRepository.save(livro));
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(colaboradoresSalvo);
    }

    public ResponseEntity<Colaborador> atualizarColaborador(Long id, Colaborador colaborador){
        if(colaboradorRepository.existsById(id)){
            colaborador.setId(id);
            For(Livro livro : colaborador.getLivros()){
            //     livro.setColaborador(colaborador);
            }
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