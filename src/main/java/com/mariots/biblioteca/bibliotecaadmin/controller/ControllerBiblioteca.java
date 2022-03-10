package com.mariots.biblioteca.bibliotecaadmin.controller;

import com.mariots.biblioteca.bibliotecaadmin.model.Autor;
import com.mariots.biblioteca.bibliotecaadmin.service.ServiceBiblioteca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerBiblioteca {

    @Autowired
    ServiceBiblioteca service;

    @PostMapping(value="/registrarNuevoAutor")
    public ResponseEntity registrarNuevoAutor(@RequestBody Autor autor){
       Autor autorGuardado = service.guardarAutor(autor);
       return new ResponseEntity<Autor>(autorGuardado, HttpStatus.CREATED);
    }

    @GetMapping(value = "/hello")
    public String getString(){
        return "Hello World World";
    }

}
