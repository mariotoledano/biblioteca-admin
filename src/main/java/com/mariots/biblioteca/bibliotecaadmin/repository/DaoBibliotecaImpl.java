package com.mariots.biblioteca.bibliotecaadmin.repository;

import com.mariots.biblioteca.bibliotecaadmin.model.Autor;
import com.mariots.biblioteca.bibliotecaadmin.model.Supertema;
import com.mariots.biblioteca.bibliotecaadmin.model.Tema;
import com.mariots.biblioteca.bibliotecaadmin.model.Texto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DaoBibliotecaImpl implements DaoBiblioteca {
    @Autowired
    AutorJpaRepository autorJpaRepository;
    @Autowired
    TemaJpaRepository temaJpaRepository;
    @Autowired
    SupertemaJpaRepository supertemaJpaRepository;
    @Autowired
    TextoJpaRepository textoJpaRepository;

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
}
