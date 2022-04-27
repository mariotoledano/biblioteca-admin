package com.mariots.biblioteca.bibliotecarest.core.service;

import com.mariots.biblioteca.bibliotecarest.core.dtos.AutorDto;
import com.mariots.biblioteca.bibliotecarest.core.dtos.SupertemaDto;
import com.mariots.biblioteca.bibliotecarest.core.dtos.TemaDto;
import com.mariots.biblioteca.bibliotecarest.core.dtos.TextoDto;
import com.mariots.biblioteca.bibliotecarest.core.dtos.inputrest.*;
import com.mariots.biblioteca.bibliotecarest.core.dtos.objetosvinculados.TemaSupertema;
import com.mariots.biblioteca.bibliotecarest.core.dtos.objetosvinculados.TextoAutor;
import com.mariots.biblioteca.bibliotecarest.core.dtos.objetosvinculados.TextoTema;

import java.util.List;

public interface ServiceBiblioteca {
    AutorDto guardarAutor(AutorDto autorDto);
    TemaDto guardarTema(TemaDto temaDto);
    SupertemaDto guardarSupertema(SupertemaDto supertemaDto);
    TextoDto guardarTexto(TextoDto textoDto);
    AutorDto guardarAutor(AutorRest autorRest);
    TemaDto guardarTema(TemaRest temaRest);
    SupertemaDto guardarSupertema(SupertemaRest supertemaRest);
    TextoDto guardarTexto(TextoRest textoRest);
    TextoDto guardarTextoDesdePath(TextoRest texto, int idAutor, int idTema);

    List<AutorDto> recuperarAutores();
    List<TemaDto> recuperarTemas();
    List<SupertemaDto> recuperarSupertemas();
    List<TextoDto> recuperarTextos();

    AutorDto recuperarAutorPorId(int idAutor);
    TemaDto recuperarTemaPorId(int idTema);
    SupertemaDto recuperarSupertemaPorId(int idSupertema);
    TextoDto recuperarTextoPorId(int idTexto);

    AutorDto recuperarAutorPorNombre(String nombreAutor);
    TemaDto recuperarTemaPorNombre(String nombreTema);
    SupertemaDto recuperarSupertemaPorNombre(String nombreSupertema);

    List<TextoDto> recuperarTextosPorAutor(int idAutor);
    List<TextoDto> recuperarTextosPorTema(int idTema);
    List<TextoDto> recuperarTextosPorSupertema(int idSupertema);
    List<TemaDto> recuperarTemasPorSupertema(int idSupertema);

    TemaSupertema vincularTemaSupertema(int idTema, int idSupertema);
    TemaSupertema sobreescribirVinculoTemaSupertema(int idTema, int idSupertema);
    TextoTema vincularTextoTema(int idTexto, int idTema);
    TextoAutor vincularTextoAutor(int idTexto, int idAutor);
    TextoAutor sobreescribirVinculoTextoAutor(int idTexto, int idAutor);

    TemaSupertema desvincularTemaSupertema(int idTema, int idSupertema);
    TextoTema desvincularTextoTema(int idTexto, int idTema);
    TextoAutor desvincularTextoAutor(int idTexto, int idAutor);

    void eliminarAutorPorId(int idAutor);
    void eliminarTextoPorId(int idTexo);
    void eliminarTemaPorId(int idTema);
    void eliminarSupertemaPorId(int idSupertema);

    AutorDto actualizarAutorPorId(int id, AutorRest autor);
    TextoDto actualizarTextoPorId(int id, TextoRest texto);
    TemaDto actualizarTemaPorId(int id, TemaRest tema);
    SupertemaDto actualizarSupertemaPorId(int id, SupertemaRest supertema);

}
