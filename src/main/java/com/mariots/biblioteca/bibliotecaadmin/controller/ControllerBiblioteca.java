package com.mariots.biblioteca.bibliotecaadmin.controller;

import com.mariots.biblioteca.bibliotecaadmin.dtos.*;
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
//MÉTODOS DE PRUEBA
    @GetMapping(value="/autorPorId")
    public AutorDto conseguirAutorPorId(@RequestParam int idAutor){
        return service.recuperarAutorPorId(idAutor);
    }
    @GetMapping(value="/temaPorId")
    public TemaDto conseguirTemaPorId(@RequestParam int idTema){
        return service.recuperarTemaPorId(idTema);
    }

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
        List<AutorDto> listaAutores = service.recuperarAutores();
        model.addAttribute("listaAutores", listaAutores);
        List<TemaDto> listaTemas = service.recuperarTemas();
        model.addAttribute("listaTemas", listaTemas);
        return new ModelAndView("nuevo_texto", model);
    }

//REGISTRAR NUEVO
    @PostMapping(value="/registrarNuevoAutor")
    public ResponseEntity registrarNuevoAutor(@RequestBody AutorDto autor){
       System.out.println("recibido");
       AutorDto autorGuardado = service.guardarAutor(autor);
       return new ResponseEntity<AutorDto>(autorGuardado, HttpStatus.CREATED);
    }

    @PostMapping(value="/registrarNuevoTema")
    public ResponseEntity registrarNuevoTema(@RequestBody TemaDto tema){
        System.out.println("recibido");
        TemaDto temaGuardado = service.guardarTema(tema);
        return new ResponseEntity<TemaDto>(tema, HttpStatus.CREATED);
    }

    @PostMapping(value="/registrarNuevoSupertema")
    public ResponseEntity registrarNuevoSupertema(@RequestBody SupertemaDto supertema){
        System.out.println("recibido");
        SupertemaDto supertemaGuardado = service.guardarSupertema(supertema);
        return new ResponseEntity<SupertemaDto>(supertemaGuardado, HttpStatus.CREATED);
    }

//    @PostMapping(value="/registrarNuevoTexto")
//    public ResponseEntity registrarNuevoTexto(@RequestBody TextoFront textoFront){
//        System.out.println(textoFront);
//        String textoString = textoFront.getTextoString();
//        String longitud = textoFront.getLongitud();
//        AutorDto autor = service.recuperarAutorPorId(textoFront.getIdAutor());
//        List<AutorDto> autores = new ArrayList<>();
//        autores.add(autor);
//        TemaDto tema = service.recuperarTemaPorId(textoFront.getIdTema());
//        List<TemaDto> temas = new ArrayList<>();
//        temas.add(tema);
//        TextoDto textoNuevo = new TextoDto(textoString,longitud,autores, temas);
//        System.out.println(textoNuevo);
//        TextoDto textoGuardado = service.guardarNuevoTexto(textoNuevo);
//        return new ResponseEntity<TextoDto>(textoGuardado, HttpStatus.CREATED);
//    }


}

