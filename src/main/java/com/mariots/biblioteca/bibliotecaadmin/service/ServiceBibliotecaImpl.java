package com.mariots.biblioteca.bibliotecaadmin.service;

import com.mariots.biblioteca.bibliotecaadmin.exceptions.BdException;
import com.mariots.biblioteca.bibliotecaadmin.model.Autor;
import com.mariots.biblioteca.bibliotecaadmin.model.Supertema;
import com.mariots.biblioteca.bibliotecaadmin.model.Tema;
import com.mariots.biblioteca.bibliotecaadmin.model.Texto;
import com.mariots.biblioteca.bibliotecaadmin.repository.RepositoryBiblioteca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceBibliotecaImpl implements ServiceBiblioteca {
    @Autowired
    RepositoryBiblioteca repository;

    //MÉTODOS GUARDAR
    @Override
    public Autor guardarAutor(Autor autor) {
        return repository.guardarAutor(autor);
    }

    @Override
    public Tema guardarTema(Tema tema) {
        return repository.guardarTema(tema);
    }

    @Override
    public Supertema guardarSupertema(Supertema supertema) {
        return repository.guardarSupertema(supertema);
    }

    @Override
    public Texto guardarTexto(Texto texto) {
        return repository.guardarTexto(texto);
    }

    @Override
    public Texto guardarNuevoTexto(Texto texto) {
        //Añado al texto nuevo un autor y tema ya creados
        //con los métodos add.Autor y addTema también al objeto autor y tema se les añade a su lista de textos el nuevo texto
        //por eso actualizamos después ese tema y autor, para que conste ese texto nuevo en ambos
        Autor autor = texto.getAutores().get(0);
        texto.addAutor(autor);
        Tema tema = texto.getTemas().get(0);
        texto.addTema(tema);
        repository.guardarAutor(autor);
        repository.guardarTema(tema);
        return repository.guardarTexto(texto);
    }

    //MÉTODOS RECUPERAR TODOS
    @Override
    public List<Autor> recuperarAutores() {
        return repository.recuperarAutores();
    }

    @Override
    public List<Tema> recuperarTemas() {
        return repository.recuperarTemas();
    }

    @Override
    public List<Supertema> recuperarSupertemas() {
        return repository.recuperarSupertemas();
    }

    @Override
    public List<Texto> recupearTextos() {
        return repository.recupearTextos();
    }

    //MÉTODOS RECUPERAR POR ID
    @Override
    public Autor recuperarAutorPorId(int idAutor) {
        return repository.recuperarAutorPorId(idAutor).orElseThrow(BdException::new);
    }

    @Override
    public Tema recuperarTemaPorId(int idTema) {
        return repository.recuperarTemaPorId(idTema).orElseThrow(BdException::new);
    }

    @Override
    public Supertema recuperarSupertemaPorId(int idSupertema) {
        return repository.recuperarSupertemaPorId(idSupertema).orElseThrow(BdException::new);
    }

    @Override
    public Texto recuperarTextoPorId(int idTexto) {
        return repository.recuperarTextoPorId(idTexto).orElseThrow(BdException::new);
    }
}