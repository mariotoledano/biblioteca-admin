package com.mariots.biblioteca.bibliotecaadmin.api.mapper;

import com.mariots.biblioteca.bibliotecaadmin.core.dtos.AutorDto;
import com.mariots.biblioteca.bibliotecaadmin.core.dtos.SupertemaDto;
import com.mariots.biblioteca.bibliotecaadmin.core.dtos.TemaDto;
import com.mariots.biblioteca.bibliotecaadmin.core.dtos.TextoDto;
import com.mariots.biblioteca.bibliotecaadmin.core.dtos.inputrest.AutorRest;
import com.mariots.biblioteca.bibliotecaadmin.core.dtos.inputrest.SupertemaRest;
import com.mariots.biblioteca.bibliotecaadmin.core.dtos.inputrest.TemaRest;
import com.mariots.biblioteca.bibliotecaadmin.core.dtos.inputrest.TextoRest;
import com.mariots.biblioteca.bibliotecaadmin.persistence.entities.AutorEntity;
import com.mariots.biblioteca.bibliotecaadmin.persistence.entities.SupertemaEntity;
import com.mariots.biblioteca.bibliotecaadmin.persistence.entities.TemaEntity;
import com.mariots.biblioteca.bibliotecaadmin.persistence.entities.TextoEntity;

public interface Mapper {

    //Entidad <--> Dto

    AutorDto toDto(AutorEntity autorEntity);
    AutorEntity toEntity(AutorDto autorDto);

    SupertemaDto toDto(SupertemaEntity supertemaEntity);
    SupertemaEntity toEntity(SupertemaDto supertemaDto);

    TemaDto toDto(TemaEntity temaEntity);
    TemaEntity toEntity(TemaDto temaDto);

    TextoDto toDto(TextoEntity textoEntity);
    TextoEntity toEntity(TextoDto textoDto);

    //Rest --> Dto

    AutorDto toDto(AutorRest autorRest);
    TextoDto toDto(TextoRest textoRest);
    TemaDto toDto(TemaRest temaRest);
    SupertemaDto toDto(SupertemaRest supertemaRest);

}
