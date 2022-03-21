package com.mariots.biblioteca.bibliotecaadmin.service;

import com.mariots.biblioteca.bibliotecaadmin.dtos.AutorDto;
import com.mariots.biblioteca.bibliotecaadmin.dtos.SupertemaDto;
import com.mariots.biblioteca.bibliotecaadmin.dtos.TemaDto;
import com.mariots.biblioteca.bibliotecaadmin.dtos.TextoDto;
import com.mariots.biblioteca.bibliotecaadmin.mapper.AutorMapper;
import com.mariots.biblioteca.bibliotecaadmin.mapper.SupertemaMapper;
import com.mariots.biblioteca.bibliotecaadmin.mapper.TemaMapper;
import com.mariots.biblioteca.bibliotecaadmin.mapper.TextoMapper;
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
    AutorMapper autorMapper;
    @Autowired
    TemaMapper temaMapper;
    @Autowired
    SupertemaMapper supertemaMapper;
    @Autowired
    TextoMapper textoMapper;

    //MÉTODOS GUARDAR
    @Override
    public AutorDto guardarAutor(AutorDto autorDto) {

        return autorMapper.toDto(repository.guardarAutor(autorMapper.toEntity(autorDto)));
    }

    @Override
    public TemaDto guardarTema(TemaDto temaDto) {
        return temaMapper.toDto(repository.guardarTema(temaMapper.toEntity(temaDto)));
    }

    @Override
    public SupertemaDto guardarSupertema(SupertemaDto supertemaDto) {
        return supertemaMapper.toDto(repository.guardarSupertema(supertemaMapper.toEntity(supertemaDto)));
    }

    @Override
    public TextoDto guardarTexto(TextoDto textoDto) {
        return textoMapper.toDto(repository.guardarTexto(textoMapper.toEntity(textoDto)));
    }

    @Override
    public TextoDto guardarNuevoTexto(TextoDto textoDto) {
        //Añado al texto nuevo un autor y tema ya creados
        //con los métodos add.Autor y addTema también al objeto autor y tema se les añade a su lista de textos el nuevo texto
        //por eso actualizamos después ese tema y autor, para que conste ese texto nuevo en ambos
//        Autor autor = texto.getAutores().get(0);
//        texto.addAutor(autor);
//        Tema tema = texto.getTemas().get(0);
//        texto.addTema(tema);
//        repository.guardarAutor(autor);
//        repository.guardarTema(tema);
        return textoMapper.toDto(repository.guardarTexto(textoMapper.toEntity(textoDto)));
    }

    //MÉTODOS RECUPERAR TODOS
    @Override
    public List<AutorDto> recuperarAutores() {
        return repository.recuperarAutores().stream().map(autorMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<TemaDto> recuperarTemas() {
        return repository.recuperarTemas().stream().map(temaMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<SupertemaDto> recuperarSupertemas() {
        return repository.recuperarSupertemas().stream().map(supertemaMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<TextoDto> recupearTextos() {
        return repository.recupearTextos().stream().map(textoMapper::toDto).collect(Collectors.toList());
    }

    //MÉTODOS RECUPERAR POR ID
    @Override
    public AutorDto recuperarAutorPorId(int idAutor) {
        return repository.recuperarAutorPorId(idAutor).map(autorMapper::toDto).orElseThrow();
    }

    @Override
    public TemaDto recuperarTemaPorId(int idTema) {
        return repository.recuperarTemaPorId(idTema).map(temaMapper::toDto).orElseThrow();
    }

    @Override
    public SupertemaDto recuperarSupertemaPorId(int idSupertema) {
        return repository.recuperarSupertemaPorId(idSupertema).map(supertemaMapper::toDto).orElseThrow();
    }

    @Override
    public TextoDto recuperarTextoPorId(int idTexto) {
        return repository.recuperarTextoPorId(idTexto).map(textoMapper::toDto).orElseThrow();
    }
}