// package com.example.app.service;

// import java.util.List;
// import java.util.ArrayList;
// import java.util.HashMap;
// import java.util.Map;

// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.stereotype.Service;

// import com.example.app.entity.Colaborador;

// @Service
// public class ColaboradorService {  

//     // variavel com 2 parametros e já iniciada
//     private static Map<Long, Colaborador> listaColaboradores = new HashMap<>();

//     public ResponseEntity<Colaborador> buscarColaboradorPorId(Long id){
//      Colaborador colaborador = listaColaboradores.get(id);
//      if(colaborador == null){
//         return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//      } else {
//         return ResponseEntity.status(HttpStatus.OK).body(colaborador);
//      }
//     }

//     public List<Colaborador> buscarTodosColaboradores(){
//      return new ArrayList<>(listaColaboradores.values());
//     }

//     public ResponseEntity<Colaborador> cadastrarColaborador(Colaborador colaborador){
//         listaColaboradores.put(colaborador.getId(), colaborador);
//         return ResponseEntity.status(HttpStatus.OK).body(colaborador);
//     }

//     public ResponseEntity<Colaborador> atualizarColaborador(Colaborador colaborador){
//         Colaborador colaboradorEncontrado = listaColaboradores.get(colaborador.getId());
//         if(colaboradorEncontrado == null){
//             return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//         }
//         listaColaboradores.put(colaborador.getId(), colaborador);
//         return ResponseEntity.status(HttpStatus.OK).body(colaboradorEncontrado);
//     }

//     public ResponseEntity<String> removerEstudante(Long id){
//         Colaborador colaboradorEncontrado = listaColaboradores.get(id);
//         if(colaboradorEncontrado == null){
//             return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//         }
//         listaColaboradores.remove(id);
//         return ResponseEntity.status(HttpStatus.OK).body("Colaborador removido");
//     }


// }
