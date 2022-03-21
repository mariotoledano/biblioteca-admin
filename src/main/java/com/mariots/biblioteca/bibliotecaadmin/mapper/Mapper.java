package com.mariots.biblioteca.bibliotecaadmin.mapper;

import com.mariots.biblioteca.bibliotecaadmin.dtos.AutorDto;
import com.mariots.biblioteca.bibliotecaadmin.dtos.SupertemaDto;
import com.mariots.biblioteca.bibliotecaadmin.dtos.TemaDto;
import com.mariots.biblioteca.bibliotecaadmin.dtos.TextoDto;
import com.mariots.biblioteca.bibliotecaadmin.entities.AutorEntity;
import com.mariots.biblioteca.bibliotecaadmin.entities.SupertemaEntity;
import com.mariots.biblioteca.bibliotecaadmin.entities.TemaEntity;
import com.mariots.biblioteca.bibliotecaadmin.entities.TextoEntity;

public interface Mapper {

    AutorDto toDto(AutorEntity autorEntity);
    AutorEntity toEntity(AutorDto autorDto);

    SupertemaDto toDto(SupertemaEntity supertemaEntity);
    SupertemaEntity toEntity(SupertemaDto supertemaDto);

    TemaDto toDto(TemaEntity temaEntity);
    TemaEntity toEntity(TemaDto temaDto);

    TextoDto toDto(TextoEntity textoEntity);
    TextoEntity toEntity(TextoDto textoDto);



}
