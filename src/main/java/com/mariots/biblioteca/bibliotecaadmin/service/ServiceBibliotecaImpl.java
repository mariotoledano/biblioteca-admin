package com.mariots.biblioteca.bibliotecaadmin.service;

import com.mariots.biblioteca.bibliotecaadmin.model.Autor;
import com.mariots.biblioteca.bibliotecaadmin.repository.DaoBiblioteca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceBibliotecaImpl implements ServiceBiblioteca {
    @Autowired
    DaoBiblioteca daoInterface;
    @Override
    public Autor guardarAutor(Autor autor) {
        return daoInterface.guardarAutor(autor);
    }
}
