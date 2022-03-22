package com.mariots.biblioteca.bibliotecaadmin.persistence.repository;

import com.mariots.biblioteca.bibliotecaadmin.persistence.entities.AutorEntity;
import com.mariots.biblioteca.bibliotecaadmin.persistence.entities.SupertemaEntity;
import com.mariots.biblioteca.bibliotecaadmin.persistence.entities.TemaEntity;
import com.mariots.biblioteca.bibliotecaadmin.persistence.entities.TextoEntity;

import java.util.List;
import java.util.Optional;

public interface RepositoryBiblioteca {
    public AutorEntity guardarAutor(AutorEntity autorEntity);
    public TemaEntity guardarTema(TemaEntity temaEntity);
    public SupertemaEntity guardarSupertema(SupertemaEntity supertemaEntity);
    public TextoEntity guardarTexto(TextoEntity textoEntity);

    public List<AutorEntity> recuperarAutores();
    public List<TemaEntity> recuperarTemas();
    public List<SupertemaEntity> recuperarSupertemas();
    public List<TextoEntity> recupearTextos();

    public Optional<AutorEntity> recuperarAutorPorId(int idAutor);
    public Optional<TemaEntity> recuperarTemaPorId(int idTema);
    public Optional<SupertemaEntity> recuperarSupertemaPorId(int idSupertema);
    public Optional<TextoEntity> recuperarTextoPorId(int idTexto);

}
