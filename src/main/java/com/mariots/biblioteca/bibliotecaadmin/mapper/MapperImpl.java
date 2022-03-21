package com.mariots.biblioteca.bibliotecaadmin.mapper;

import com.mariots.biblioteca.bibliotecaadmin.dtos.AutorDto;
import com.mariots.biblioteca.bibliotecaadmin.dtos.SupertemaDto;
import com.mariots.biblioteca.bibliotecaadmin.dtos.TemaDto;
import com.mariots.biblioteca.bibliotecaadmin.dtos.TextoDto;
import com.mariots.biblioteca.bibliotecaadmin.entities.AutorEntity;
import com.mariots.biblioteca.bibliotecaadmin.entities.SupertemaEntity;
import com.mariots.biblioteca.bibliotecaadmin.entities.TemaEntity;
import com.mariots.biblioteca.bibliotecaadmin.entities.TextoEntity;
import org.springframework.stereotype.Component;
import java.util.stream.Collectors;
@Component
public class MapperImpl implements Mapper{
    @Override
    public AutorDto toDto(AutorEntity autorEntity) {
        AutorDto autorDto = new AutorDto();
        autorDto.setIdAutor(autorEntity.getIdAutor());
        autorDto.setNombreAutor(autorEntity.getNombreAutor());
        autorDto.setDescripcionBreve(autorEntity.getDescripcionBreve());
        autorDto.setDescripcionLarga(autorEntity.getDescripcionLarga());
        autorDto.setIdTextos(autorEntity.getTextos().stream().map((t)->(t.getIdTexto())).collect(Collectors.toList()));
        return autorDto;
    }

    @Override
    public AutorEntity toEntity(AutorDto autorDto) {
        return null;
    }

    @Override
    public SupertemaDto toDto(SupertemaEntity supertemaEntity) {
        SupertemaDto supertemaDto = new SupertemaDto();
        supertemaDto.setIdSupertema(supertemaEntity.getIdSupertema());
        supertemaDto.setNombreSupertema(supertemaEntity.getNombreSupertema());
        supertemaDto.setIdTemas(supertemaEntity.getTemas().stream().map(TemaEntity::getIdTema).collect(Collectors.toList()));
        return supertemaDto;
    }

    @Override
    public SupertemaEntity toEntity(SupertemaDto supertemaDto) {
        return null;
    }

    @Override
    public TemaDto toDto(TemaEntity temaEntity) {
       TemaDto temaDto= new TemaDto();
       temaDto.setIdTema(temaEntity.getIdTema());
       temaDto.setNombreTema(temaEntity.getNombreTema());
       temaDto.setIdSupertema(temaEntity.getSupertema().getIdSupertema());
       temaDto.setIdTextos(temaEntity.getTextos().stream().map(TextoEntity::getIdTexto).collect(Collectors.toList()));
       return temaDto;
    }

    @Override
    public TemaEntity toEntity(TemaDto temaDto) {
        return null;
    }

    @Override
    public TextoDto toDto(TextoEntity textoEntity) {
        TextoDto textoDto =new TextoDto();
        textoDto.setIdTexto(textoEntity.getIdTexto());
        textoDto.setTextoString(textoEntity.getTextoString());
        textoDto.setLongitud(textoEntity.getLongitud());
        textoDto.setIdTemas(textoEntity.getTemas().stream().map(TemaEntity::getIdTema).collect(Collectors.toList()));
        textoDto.setIdAutor(textoEntity.getAutor().getIdAutor());
        return textoDto;
    }

    @Override
    public TextoEntity toEntity(TextoDto textoDto) {
        return null;
    }
}
