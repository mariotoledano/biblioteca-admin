package com.mariots.biblioteca.bibliotecaadmin.core.controller;

import com.mariots.biblioteca.bibliotecaadmin.api.mapper.Mapper;
import com.mariots.biblioteca.bibliotecaadmin.core.dtos.AutorDto;
import com.mariots.biblioteca.bibliotecaadmin.core.dtos.SupertemaDto;
import com.mariots.biblioteca.bibliotecaadmin.core.dtos.TemaDto;
import com.mariots.biblioteca.bibliotecaadmin.core.dtos.TextoDto;
import com.mariots.biblioteca.bibliotecaadmin.core.dtos.nuevorest.NuevoAutorRest;
import com.mariots.biblioteca.bibliotecaadmin.core.dtos.nuevorest.NuevoSupertemaRest;
import com.mariots.biblioteca.bibliotecaadmin.core.dtos.nuevorest.NuevoTemaRest;
import com.mariots.biblioteca.bibliotecaadmin.core.dtos.nuevorest.NuevoTextoRest;
import com.mariots.biblioteca.bibliotecaadmin.core.service.ServiceBiblioteca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControllerBibliotecaRest {

    @Autowired
    ServiceBiblioteca service;
    @Autowired
    Mapper mapper;

    //GET resource -- Recuperar todos los resources de un tipo
    @GetMapping(value="/autores")
    public ResponseEntity recuperarAutores(){
        List<AutorDto> autores = service.recuperarAutores();
        return new ResponseEntity<List<AutorDto>>(autores, HttpStatus.FOUND);
    }
    @GetMapping(value ="/textos")
    public ResponseEntity recuperarTextos(){
        List<TextoDto> textos= service.recupearTextos();
        return new ResponseEntity<List<TextoDto>>(textos, HttpStatus.FOUND);
    }
    @GetMapping(value ="/temas")
    public ResponseEntity recuperarTemas(){
        List<TemaDto> temas= service.recuperarTemas();
        return new ResponseEntity<List<TemaDto>>(temas, HttpStatus.FOUND);
    }
    @GetMapping(value ="/supertemas")
    public ResponseEntity recuperarSupertemas(){
        List<SupertemaDto> supertemas= service.recuperarSupertemas();
        return new ResponseEntity<List<SupertemaDto>>(supertemas, HttpStatus.FOUND);
    }

    //GET resource/{id} -- Recuperar recurso por id
    @GetMapping(value="/autores/{id}")
    public ResponseEntity recuperarAutoresPorId(@PathVariable int id){
        AutorDto autor = service.recuperarAutorPorId(id);
        return new ResponseEntity<AutorDto>(autor, HttpStatus.FOUND);
    }
    @GetMapping(value ="/textos/{id}")
    public ResponseEntity recuperarTextosPorId(@PathVariable int id){
        TextoDto texto = service.recuperarTextoPorId(id);
        return new ResponseEntity<TextoDto>(texto, HttpStatus.FOUND);
    }
    @GetMapping(value ="/temas/{id}")
    public ResponseEntity recuperarTemasPorId(@PathVariable int id){
        TemaDto tema = service.recuperarTemaPorId(id);
        return new ResponseEntity<TemaDto>(tema, HttpStatus.FOUND);
    }
    @GetMapping(value ="/supertemas/{id}")
    public ResponseEntity recuperarSupertemasPorId(@PathVariable int id){
        SupertemaDto supertema = service.recuperarSupertemaPorId(id);
        return new ResponseEntity<SupertemaDto>(supertema, HttpStatus.FOUND);
    }
    //GET resource/nombre/{nombre} -- Recuperar recurso por nombre
    @GetMapping(value="/autores/nombre/{nombreAutor}")
    public ResponseEntity recuperarAutoresPorNombre(@PathVariable String nombreAutor){
        AutorDto autor = service.recuperarAutorPorNombre(nombreAutor);
        return new ResponseEntity<AutorDto>(autor, HttpStatus.FOUND);
    }
    @GetMapping(value ="/temas/nombre/{nombreTema}")
    public ResponseEntity recuperarTemasPorNombre(@PathVariable String nombreTema){
        TemaDto tema = service.recuperarTemaPorNombre(nombreTema);
        return new ResponseEntity<TemaDto>(tema, HttpStatus.FOUND);
    }
    @GetMapping(value ="/supertemas/nombre/{nombreSupertema}")
    public ResponseEntity recuperarSupertemasPorId(@PathVariable String nombreSupertema) {
        SupertemaDto supertema = service.recuperarSupertemaPorNombre(nombreSupertema);
        return new ResponseEntity<SupertemaDto>(supertema, HttpStatus.FOUND);
    }
    //POST resource -- Creación nuevo resource
    @PostMapping(value="/autores")
    public ResponseEntity registrarNuevoAutor(@RequestBody NuevoAutorRest autor){
        AutorDto autorGuardado = service.guardarAutor(mapper.toDto(autor));
        return new ResponseEntity<AutorDto>(autorGuardado, HttpStatus.CREATED);
    }

    @PostMapping(value="/temas")
    public ResponseEntity registrarNuevoTema(@RequestBody NuevoTemaRest tema){
        TemaDto temaGuardado = service.guardarTema(mapper.toDto(tema));
        return new ResponseEntity<TemaDto>(temaGuardado, HttpStatus.CREATED);
    }

    @PostMapping(value="/supertemas")
    public ResponseEntity registrarNuevoSupertema(@RequestBody NuevoSupertemaRest supertema){
        SupertemaDto supertemaGuardado = service.guardarSupertema(mapper.toDto(supertema));
        return new ResponseEntity<SupertemaDto>(supertemaGuardado, HttpStatus.CREATED);
    }

    @PostMapping(value="/textos")
    public ResponseEntity registrarNuevoTexto(@RequestBody NuevoTextoRest texto){
        TextoDto textoGuardado = service.guardarTexto(mapper.toDto(texto));
        return new ResponseEntity<TextoDto>(textoGuardado, HttpStatus.CREATED);
    }

    //PUT vincular tema -->> supertema
    @PutMapping(value="/temas/{idTema}/supertemas/{idSupertema}")
    public ResponseEntity vincularTemaSupertema(@PathVariable int idTema, @PathVariable int idSupertema){
        TemaDto temaGuardado= service.vincularTemaSupertema(idTema, idSupertema);
        return new ResponseEntity<TemaDto>(temaGuardado, HttpStatus.CREATED);
    }
}
