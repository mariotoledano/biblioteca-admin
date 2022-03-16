package com.mariots.biblioteca.bibliotecaadmin.service;

import com.mariots.biblioteca.bibliotecaadmin.dtos.AutorDto;
import com.mariots.biblioteca.bibliotecaadmin.dtos.SupertemaDto;
import com.mariots.biblioteca.bibliotecaadmin.dtos.TemaDto;
import com.mariots.biblioteca.bibliotecaadmin.dtos.TextoDto;

import java.util.List;

public interface ServiceBiblioteca {
    public AutorDto guardarAutor(AutorDto autorDto);
    public TemaDto guardarTema(TemaDto temaDto);
    public SupertemaDto guardarSupertema(SupertemaDto supertemaDto);
    public TextoDto guardarTexto(TextoDto textoDto);
    public TextoDto guardarNuevoTexto(TextoDto textoDto);

    public List<AutorDto> recuperarAutores();
    public List<TemaDto> recuperarTemas();
    public List<SupertemaDto> recuperarSupertemas();
    public List<TextoDto> recupearTextos();

    public AutorDto recuperarAutorPorId(int idAutor);
    public TemaDto recuperarTemaPorId(int idTema);
    public SupertemaDto recuperarSupertemaPorId(int idSupertema);
    public TextoDto recuperarTextoPorId(int idTexto);
}
