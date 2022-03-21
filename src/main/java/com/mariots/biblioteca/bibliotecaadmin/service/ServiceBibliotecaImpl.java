package com.mariots.biblioteca.bibliotecaadmin.service;

import com.mariots.biblioteca.bibliotecaadmin.dtos.AutorDto;
import com.mariots.biblioteca.bibliotecaadmin.dtos.SupertemaDto;
import com.mariots.biblioteca.bibliotecaadmin.dtos.TemaDto;
import com.mariots.biblioteca.bibliotecaadmin.dtos.TextoDto;
import com.mariots.biblioteca.bibliotecaadmin.entities.TemaEntity;
import com.mariots.biblioteca.bibliotecaadmin.mapper.Mapper;
import com.mariots.biblioteca.bibliotecaadmin.repository.RepositoryBiblioteca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceBibliotecaImpl implements ServiceBiblioteca {
    @Autowired
    RepositoryBiblioteca repository;
   @Autowired
    Mapper mapper;

    //MÉTODOS GUARDAR
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! MAPPER NO PREPARADO PARA TO ENTITY AFECTA MÉTODOS GUARDADO
    @Override
    public AutorDto guardarAutor(AutorDto autorDto) {
        return mapper.toDto(repository.guardarAutor(mapper.toEntity(autorDto)));
    }

    @Override
    public TemaDto guardarTema(TemaDto temaDto) {
        return mapper.toDto(repository.guardarTema(mapper.toEntity(temaDto)));
    }

    @Override
    public SupertemaDto guardarSupertema(SupertemaDto supertemaDto) {
        return mapper.toDto(repository.guardarSupertema(mapper.toEntity(supertemaDto)));
    }

    @Override
    public TextoDto guardarTexto(TextoDto textoDto) {
        return mapper.toDto(repository.guardarTexto(mapper.toEntity(textoDto)));
    }

//    @Override
//    public TextoDto guardarNuevoTexto(TextoDto textoDto) {
//        //Añado al texto nuevo un autor y tema ya creados
//        //con los métodos add.Autor y addTema también al objeto autor y tema se les añade a su lista de textos el nuevo texto
//        //por eso actualizamos después ese tema y autor, para que conste ese texto nuevo en ambos
////        Autor autor = texto.getAutores().get(0);
////        texto.addAutor(autor);
////        Tema tema = texto.getTemas().get(0);
////        texto.addTema(tema);
////        repository.guardarAutor(autor);
////        repository.guardarTema(tema);
//        return mapper.toDto(repository.guardarTexto(repository.recuperarTextoPorId(textoDto.getIdTexto()).get()));
//    }

    //MÉTODOS RECUPERAR TODOS
    @Override
    public List<AutorDto> recuperarAutores() {
        return repository.recuperarAutores().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<TemaDto> recuperarTemas() {
        return repository.recuperarTemas().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<SupertemaDto> recuperarSupertemas() {
        return repository.recuperarSupertemas().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<TextoDto> recupearTextos() {
        return repository.recupearTextos().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    //MÉTODOS RECUPERAR POR ID
    @Override
    public AutorDto recuperarAutorPorId(int idAutor) {
        return repository.recuperarAutorPorId(idAutor).map(mapper::toDto).get();
    }

    @Override
    public TemaDto recuperarTemaPorId(int idTema) {
        return repository.recuperarTemaPorId(idTema).map(mapper::toDto).get();
    }

    @Override
    public SupertemaDto recuperarSupertemaPorId(int idSupertema) {
        return repository.recuperarSupertemaPorId(idSupertema).map(mapper::toDto).get();
    }

    @Override
    public TextoDto recuperarTextoPorId(int idTexto) {
        return repository.recuperarTextoPorId(idTexto).map(mapper::toDto).get();
    }
}