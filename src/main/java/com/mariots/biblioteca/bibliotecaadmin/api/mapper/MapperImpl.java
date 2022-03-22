package com.mariots.biblioteca.bibliotecaadmin.api.mapper;

import com.mariots.biblioteca.bibliotecaadmin.core.dtos.AutorDto;
import com.mariots.biblioteca.bibliotecaadmin.core.dtos.SupertemaDto;
import com.mariots.biblioteca.bibliotecaadmin.core.dtos.TemaDto;
import com.mariots.biblioteca.bibliotecaadmin.core.dtos.TextoDto;
import com.mariots.biblioteca.bibliotecaadmin.persistence.entities.AutorEntity;
import com.mariots.biblioteca.bibliotecaadmin.persistence.entities.SupertemaEntity;
import com.mariots.biblioteca.bibliotecaadmin.persistence.entities.TemaEntity;
import com.mariots.biblioteca.bibliotecaadmin.persistence.entities.TextoEntity;
import com.mariots.biblioteca.bibliotecaadmin.persistence.repository.RepositoryBiblioteca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Component
public class MapperImpl implements Mapper{

    @Autowired
    RepositoryBiblioteca repository;

    @Override
    public AutorDto toDto(AutorEntity autorEntity) {
        AutorDto autorDto = new AutorDto();
        autorDto.setIdAutor(autorEntity.getIdAutor());
        autorDto.setNombreAutor(autorEntity.getNombreAutor());
        autorDto.setDescripcionBreve(autorEntity.getDescripcionBreve());
        autorDto.setDescripcionLarga(autorEntity.getDescripcionLarga());
        if (autorEntity.getTextos() == null){
        } else autorDto.setIdTextos(autorEntity.getTextos().stream().map((t)->(t.getIdTexto())).collect(Collectors.toList()));
        return autorDto;
    }

    @Override
    public AutorEntity toEntity(AutorDto autorDto) {
        AutorEntity autorEntity = new AutorEntity();
        //El id se define en BD
//        autorEntity.setIdAutor(autorDto.getIdAutor());
        autorEntity.setNombreAutor(autorDto.getNombreAutor());
        autorEntity.setFechaAutor(autorDto.getFechaAutor());
        autorEntity.setDescripcionBreve(autorDto.getDescripcionBreve());
        autorEntity.setDescripcionLarga(autorDto.getDescripcionLarga());
        if (autorDto.getIdTextos() == null) {
        } else {
            List<TextoEntity> listaTextosEntity= new ArrayList<>();
            autorDto.getIdTextos().stream().map((id)->listaTextosEntity.add(repository.recuperarTextoPorId(id).get())).collect(Collectors.toList());
            autorEntity.setTextos(listaTextosEntity);
        }
        return autorEntity;
    }

    @Override
    public SupertemaDto toDto(SupertemaEntity supertemaEntity) {
        SupertemaDto supertemaDto = new SupertemaDto();
        supertemaDto.setIdSupertema(supertemaEntity.getIdSupertema());
        supertemaDto.setNombreSupertema(supertemaEntity.getNombreSupertema());
        if(supertemaEntity.getTemas() == null){
        } else supertemaDto.setIdTemas(supertemaEntity.getTemas().stream().map(TemaEntity::getIdTema).collect(Collectors.toList()));
        return supertemaDto;
    }

    @Override
    public SupertemaEntity toEntity(SupertemaDto supertemaDto) {
        SupertemaEntity supertemaEntity = new SupertemaEntity();
        supertemaEntity.setNombreSupertema(supertemaDto.getNombreSupertema());
        if (supertemaEntity.getTemas() == null) {
        } else {
            List<TemaEntity> listaTemasEntity = new ArrayList<>();
            supertemaDto.getIdTemas().stream().map((id)->listaTemasEntity.add(repository.recuperarTemaPorId(id).get())).collect(Collectors.toList());
            supertemaEntity.setTemas(listaTemasEntity);
        }
        return supertemaEntity;
    }

    @Override
    public TemaDto toDto(TemaEntity temaEntity) {
       TemaDto temaDto= new TemaDto();
       temaDto.setIdTema(temaEntity.getIdTema());
       temaDto.setNombreTema(temaEntity.getNombreTema());
        if (temaEntity.getSupertema() == null) {
        } else temaDto.setIdSupertema(temaEntity.getSupertema().getIdSupertema());
        if (temaEntity.getTextos() == null) {
        } else temaDto.setIdTextos(temaEntity.getTextos().stream().map(TextoEntity::getIdTexto).collect(Collectors.toList()));
       return temaDto;
    }

    @Override
    public TemaEntity toEntity(TemaDto temaDto) {
        TemaEntity temaEntity= new TemaEntity();
        temaEntity.setNombreTema(temaDto.getNombreTema());
        if (temaEntity.getTextos() == null) {
        }else{
            List<TextoEntity> listaTextosEntity = new ArrayList<>();
            temaDto.getIdTextos().stream().map((id)->listaTextosEntity.add(repository.recuperarTextoPorId(id).get())).collect(Collectors.toList());
            temaEntity.setTextos(listaTextosEntity);
        }
        return temaEntity;
    }

    @Override
    public TextoDto toDto(TextoEntity textoEntity) {
        TextoDto textoDto =new TextoDto();
        textoDto.setIdTexto(textoEntity.getIdTexto());
        textoDto.setTextoString(textoEntity.getTextoString());
        textoDto.setLongitud(textoEntity.getLongitud());
        if (textoEntity.getTemas() == null) {
        } else textoDto.setIdTemas(textoEntity.getTemas().stream().map(TemaEntity::getIdTema).collect(Collectors.toList()));
        if (textoEntity.getAutor() == null) {
        } else textoDto.setIdAutor(textoEntity.getAutor().getIdAutor());
        return textoDto;
    }

    @Override
    public TextoEntity toEntity(TextoDto textoDto) {
        TextoEntity textoEntity = new TextoEntity();
        textoEntity.setTextoString(textoDto.getTextoString());
        textoEntity.setLongitud(textoDto.getLongitud());
        if (textoDto.getIdAutor() == null) {
        } else{
           textoEntity.setAutor(repository.recuperarAutorPorId(textoDto.getIdAutor()).get());
        }
        if (textoDto.getIdTemas() == null) {
        } else{
            List<TemaEntity> listaTemasEntity = new ArrayList<>();
            textoDto.getIdTemas().stream().map((id)->listaTemasEntity.add(repository.recuperarTemaPorId(id).get())).collect(Collectors.toList());
        }
        return textoEntity;
    }

}
