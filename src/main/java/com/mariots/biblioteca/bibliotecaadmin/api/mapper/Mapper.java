package com.mariots.biblioteca.bibliotecaadmin.api.mapper;

import com.mariots.biblioteca.bibliotecaadmin.core.dtos.AutorDto;
import com.mariots.biblioteca.bibliotecaadmin.core.dtos.SupertemaDto;
import com.mariots.biblioteca.bibliotecaadmin.core.dtos.TemaDto;
import com.mariots.biblioteca.bibliotecaadmin.core.dtos.TextoDto;
import com.mariots.biblioteca.bibliotecaadmin.persistence.entities.AutorEntity;
import com.mariots.biblioteca.bibliotecaadmin.persistence.entities.SupertemaEntity;
import com.mariots.biblioteca.bibliotecaadmin.persistence.entities.TemaEntity;
import com.mariots.biblioteca.bibliotecaadmin.persistence.entities.TextoEntity;

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
