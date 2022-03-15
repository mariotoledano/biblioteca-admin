package com.mariots.biblioteca.bibliotecaadmin.controller;

import com.mariots.biblioteca.bibliotecaadmin.entity.Autor;
import com.mariots.biblioteca.bibliotecaadmin.entity.Supertema;
import com.mariots.biblioteca.bibliotecaadmin.entity.Tema;
import com.mariots.biblioteca.bibliotecaadmin.entity.Texto;
import com.mariots.biblioteca.bibliotecaadmin.model.TextoFront;
import com.mariots.biblioteca.bibliotecaadmin.service.ServiceBiblioteca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping
public class ControllerBiblioteca {

    @Autowired
    ServiceBiblioteca service;

//ÓRDENES DE REDIRECCIÓN
    @GetMapping(value="/nuevoTema")
    public ModelAndView irNuevoTema(ModelMap model){
        return new ModelAndView("nuevo_tema");
    }

    @GetMapping(value="/nuevoAutor")
    public ModelAndView irNuevoAutor(ModelMap model){
        return new ModelAndView("nuevo_autor");
    }

    @GetMapping(value="/nuevoTexto")
    public ModelAndView irNuevoTexto(ModelMap model){
        List<Autor> listaAutores = service.recuperarAutores();
        model.addAttribute("listaAutores", listaAutores);
        List<Tema> listaTemas = service.recuperarTemas();
        model.addAttribute("listaTemas",listaTemas);
        return new ModelAndView("nuevo_texto", model);
    }

//REGISTRAR NUEVO
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
    public ResponseEntity registrarNuevoTexto(@RequestBody TextoFront textoFront){
        System.out.println(textoFront);
        String textoString = textoFront.getTextoString();
        String longitud = textoFront.getLongitud();
        Autor autor = service.recuperarAutorPorId(textoFront.getIdAutor());
        List<Autor> autores = new ArrayList<>();
        autores.add(autor);
        Tema tema = service.recuperarTemaPorId(textoFront.getIdTema());
        List<Tema> temas = new ArrayList<>();
        temas.add(tema);
        Texto textoNuevo = new Texto(textoString,longitud,autores,temas);
        System.out.println(textoNuevo);
        Texto textoGuardado = service.guardarNuevoTexto(textoNuevo);
        return new ResponseEntity<Texto>(textoGuardado, HttpStatus.CREATED);
    }


}

