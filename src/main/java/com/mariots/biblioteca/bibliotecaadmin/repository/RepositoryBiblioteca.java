package com.mariots.biblioteca.bibliotecaadmin.repository;

import com.mariots.biblioteca.bibliotecaadmin.model.Autor;
import com.mariots.biblioteca.bibliotecaadmin.model.Supertema;
import com.mariots.biblioteca.bibliotecaadmin.model.Tema;
import com.mariots.biblioteca.bibliotecaadmin.model.Texto;

import java.util.List;
import java.util.Optional;

public interface RepositoryBiblioteca {
    public Autor guardarAutor(Autor autor);
    public Tema guardarTema(Tema tema);
    public Supertema guardarSupertema(Supertema supertema);
    public Texto guardarTexto(Texto texto);

    public List<Autor> recuperarAutores();
    public List<Tema> recuperarTemas();
    public List<Supertema> recuperarSupertemas();
    public List<Texto> recupearTextos();

    public Optional<Autor> recuperarAutorPorId(int idAutor);
    public Optional<Tema> recuperarTemaPorId(int idTema);
    public Optional<Supertema> recuperarSupertemaPorId(int idSupertema);
    public Optional<Texto> recuperarTextoPorId(int idTexto);

}
