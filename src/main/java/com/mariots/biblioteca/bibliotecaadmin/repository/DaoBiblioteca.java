package com.mariots.biblioteca.bibliotecaadmin.repository;

import com.mariots.biblioteca.bibliotecaadmin.model.Autor;
import com.mariots.biblioteca.bibliotecaadmin.model.Supertema;
import com.mariots.biblioteca.bibliotecaadmin.model.Tema;
import com.mariots.biblioteca.bibliotecaadmin.model.Texto;

public interface DaoBiblioteca {
    public Autor guardarAutor(Autor autor);
    public Tema guardarTema(Tema tema);
    public Supertema guardarSupertema(Supertema supertema);
    public Texto guardarTexto(Texto texto);

}
