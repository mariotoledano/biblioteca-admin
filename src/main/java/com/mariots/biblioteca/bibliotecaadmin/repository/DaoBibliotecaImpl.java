package com.mariots.biblioteca.bibliotecaadmin.repository;

import com.mariots.biblioteca.bibliotecaadmin.model.Autor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DaoBibliotecaImpl implements DaoBiblioteca {
    @Autowired
    AutorJpaRepository auotorJpaRepository;

    @Override
    public Autor guardarAutor(Autor autor) {
        return auotorJpaRepository.save(autor);
    }
}
