package com.mariots.biblioteca.bibliotecaadmin.core.service;

import com.mariots.biblioteca.bibliotecaadmin.core.dtos.AutorDto;
import com.mariots.biblioteca.bibliotecaadmin.core.dtos.SupertemaDto;
import com.mariots.biblioteca.bibliotecaadmin.core.dtos.TemaDto;
import com.mariots.biblioteca.bibliotecaadmin.core.dtos.TextoDto;
import com.mariots.biblioteca.bibliotecaadmin.api.mapper.Mapper;
import com.mariots.biblioteca.bibliotecaadmin.persistence.repository.RepositoryBiblioteca;
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