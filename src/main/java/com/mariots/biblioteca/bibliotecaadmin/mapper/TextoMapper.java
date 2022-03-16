package com.mariots.biblioteca.bibliotecaadmin.mapper;

import com.mariots.biblioteca.bibliotecaadmin.entities.TextoEntity;
import com.mariots.biblioteca.bibliotecaadmin.dtos.TextoDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {AutorMapper.class, TemaMapper.class})
public interface TextoMapper {

    TextoEntity toEntity(TextoDto textoDto);

    TextoDto toDto(TextoEntity textoEntity);


}
