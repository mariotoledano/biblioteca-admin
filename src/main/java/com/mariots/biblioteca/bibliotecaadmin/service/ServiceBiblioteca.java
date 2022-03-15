package com.mariots.biblioteca.bibliotecaadmin.service;

import com.mariots.biblioteca.bibliotecaadmin.entity.Autor;
import com.mariots.biblioteca.bibliotecaadmin.entity.Supertema;
import com.mariots.biblioteca.bibliotecaadmin.entity.Tema;
import com.mariots.biblioteca.bibliotecaadmin.entity.Texto;

import java.util.List;

public interface ServiceBiblioteca {
    public Autor guardarAutor(Autor autor);
    public Tema guardarTema(Tema tema);
    public Supertema guardarSupertema(Supertema supertema);
    public Texto guardarTexto(Texto texto);
    public Texto guardarNuevoTexto(Texto texto);

    public List<Autor> recuperarAutores();
    public List<Tema> recuperarTemas();
    public List<Supertema> recuperarSupertemas();
    public List<Texto> recupearTextos();

    public Autor recuperarAutorPorId(int idAutor);
    public Tema recuperarTemaPorId(int idTema);
    public Supertema recuperarSupertemaPorId(int idSupertema);
    public Texto recuperarTextoPorId(int idTexto);
}
