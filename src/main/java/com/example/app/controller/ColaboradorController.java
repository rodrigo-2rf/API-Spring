package com.example.app.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.entity.Colaborador;
import com.example.app.service.ColaboradorService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("colaboradores")
@AllArgsConstructor
public class ColaboradorController{

    // usou a anotação AllArgsConstructor para a injeção de dependência
    private ColaboradorService colaboradorService;

    @GetMapping("/{id}")
    public ResponseEntity<Colaborador> buscarColaboradorPorId(@PathVariable Long id){
        return colaboradorService.buscarColaboradorPorId(id);
    }

    // @GetMapping
    // public List<Colaborador> buscarTodosColaboradores(){
    //     return colaboradorService.buscarTodosColaboradores();
    // }
    @GetMapping
    public Page<Colaborador> buscarTodosColaboradores(
        @RequestParam(defaultValue = "0") Integer pagina, 
        @RequestParam(defaultValue = "2") Integer itensPorPagina){
        return colaboradorService.buscarTodosColaboradores(PageRequest.of(pagina, itensPorPagina));
    }

    @PostMapping
    public ResponseEntity<Colaborador> cadastrarColaborador(@RequestBody Colaborador colaborador){
        return colaboradorService.cadastrarColaborador(colaborador);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Colaborador> atualizarColaborador(@PathVariable Long id, @RequestBody Colaborador colaborador){
        return colaboradorService.atualizarColaborador(id, colaborador);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removerEstudante(@PathVariable Long id){
        return colaboradorService.removerEstudante(id);
    }
}