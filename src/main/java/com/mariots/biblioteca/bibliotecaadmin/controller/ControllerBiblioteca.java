package com.mariots.biblioteca.bibliotecaadmin.controller;

import com.mariots.biblioteca.bibliotecaadmin.Utilidades;
import com.mariots.biblioteca.bibliotecaadmin.model.Autor;
import com.mariots.biblioteca.bibliotecaadmin.model.Supertema;
import com.mariots.biblioteca.bibliotecaadmin.model.Tema;
import com.mariots.biblioteca.bibliotecaadmin.model.Texto;
import com.mariots.biblioteca.bibliotecaadmin.service.ServiceBiblioteca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@RestController
@RequestMapping
public class ControllerBiblioteca {

    @Autowired
    ServiceBiblioteca service;


    @GetMapping(value="/irNuevoTexto")
    public ModelAndView irNuevoAutor(ModelMap model){
        List<Autor> listaAutores = service.recuperarAutores();
        model.addAttribute("listaAutores", listaAutores);
        List<Tema> listaTemas = service.recuperarTemas();
        model.addAttribute("listaTemas",listaTemas);
        Utilidades utilidades =new Utilidades();
        model.addAttribute("utilidades",utilidades);
        return new ModelAndView("nuevo_texto", model);
    }

    @PostMapping(value="/registrarNuevoAutor")
    public ResponseEntity registrarNuevoAutor(@RequestBody Autor autor){
       System.out.println("recibido");
       Autor autorGuardado = service.guardarAutor(autor);
       return new ResponseEntity<Autor>(autorGuardado, HttpStatus.CREATED);
    }

    @PostMapping(value="/registrarNuevoTema")
    public ResponseEntity registrarNuevoTema(@RequestBody Tema tema){
        System.out.println("recibido");
        Tema temaGuardado = service.guardarTema(tema);
        return new ResponseEntity<Tema>(temaGuardado, HttpStatus.CREATED);
    }

    @PostMapping(value="/registrarNuevoSupertema")
    public ResponseEntity registrarNuevoSupertema(@RequestBody Supertema supertema){
        System.out.println("recibido");
        Supertema supertemaGuardado = service.guardarSupertema(supertema);
        return new ResponseEntity<Supertema>(supertemaGuardado, HttpStatus.CREATED);
    }

    @PostMapping(value="/registrarNuevoTexto")
    public ResponseEntity registrarNuevoTexto(@RequestBody Texto texto){
        System.out.println(texto);
        Texto textoGuardado = service.guardarNuevoTexto(texto);
        return new ResponseEntity<Texto>(textoGuardado, HttpStatus.CREATED);
    }


}

