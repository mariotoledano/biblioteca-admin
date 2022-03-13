package com.mariots.biblioteca.bibliotecaadmin.controller;

import com.mariots.biblioteca.bibliotecaadmin.model.Autor;
import com.mariots.biblioteca.bibliotecaadmin.service.ServiceBiblioteca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

@RestController
@RequestMapping
public class ControllerBiblioteca {

    @Autowired
    ServiceBiblioteca service;

    @PostMapping(value="/registrarNuevoAutor")
    public ResponseEntity registrarNuevoAutor(@RequestBody Autor autor){
       System.out.println("recibido");
       Autor autorGuardado = service.guardarAutor(autor);
       return new ResponseEntity<Autor>(autorGuardado, HttpStatus.CREATED);
    }

    @GetMapping(value = "/hello")
    public ModelAndView getString(){
        System.out.println("recibido");
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.setViewName("nuevo_autor");
        return modelAndView;
    }

    @PostMapping(value = "/hello")
    public String postHello(){
        return "Métodod con post";
    }

}
