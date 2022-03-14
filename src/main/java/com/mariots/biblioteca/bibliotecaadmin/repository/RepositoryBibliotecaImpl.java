package com.mariots.biblioteca.bibliotecaadmin.repository;

import com.mariots.biblioteca.bibliotecaadmin.model.Autor;
import com.mariots.biblioteca.bibliotecaadmin.model.Supertema;
import com.mariots.biblioteca.bibliotecaadmin.model.Tema;
import com.mariots.biblioteca.bibliotecaadmin.model.Texto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositoryBibliotecaImpl implements RepositoryBiblioteca {
    @Autowired
    AutorJpaRepository autorJpaRepository;
    @Autowired
    TemaJpaRepository temaJpaRepository;
    @Autowired
    SupertemaJpaRepository supertemaJpaRepository;
    @Autowired
    TextoJpaRepository textoJpaRepository;

    //METODOS GUARDAR
    @Override
    public Autor guardarAutor(Autor autor) {
        return autorJpaRepository.save(autor);
    }

    @Override
    public Tema guardarTema(Tema tema) {
        return temaJpaRepository.save(tema);
    }

    @Override
    public Supertema guardarSupertema(Supertema supertema) {
        return supertemaJpaRepository.save(supertema);
    }

    @Override
    public Texto guardarTexto(Texto texto) {
        return textoJpaRepository.save(texto);
    }

    //MÉTODOS RECUPERAR
    @Override
    public List<Autor> recuperarAutores() {
        return autorJpaRepository.findAll();
    }

    @Override
    public List<Tema> recuperarTemas() {
        return temaJpaRepository.findAll();
    }

    @Override
    public List<Supertema> recuperarSupertemas() {
        return supertemaJpaRepository.findAll();
    }

    @Override
    public List<Texto> recupearTextos() {
        return textoJpaRepository.findAll();
    }

}
