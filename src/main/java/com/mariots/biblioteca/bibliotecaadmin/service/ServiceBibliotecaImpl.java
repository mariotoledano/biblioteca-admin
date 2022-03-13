package com.mariots.biblioteca.bibliotecaadmin.service;

import com.mariots.biblioteca.bibliotecaadmin.model.Autor;
import com.mariots.biblioteca.bibliotecaadmin.model.Supertema;
import com.mariots.biblioteca.bibliotecaadmin.model.Tema;
import com.mariots.biblioteca.bibliotecaadmin.model.Texto;
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

    @Override
    public Tema guardarTema(Tema tema) {
        return daoInterface.guardarTema(tema);
    }

    @Override
    public Supertema guardarSupertema(Supertema supertema) {
        return daoInterface.guardarSupertema(supertema);
    }

    @Override
    public Texto guardarTexto(Texto texto) {
        return daoInterface.guardarTexto(texto);
    }
}
