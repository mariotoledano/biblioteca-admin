package com.mariots.biblioteca.bibliotecaadmin.mapper;

import com.mariots.biblioteca.bibliotecaadmin.entities.AutorEntity;
import com.mariots.biblioteca.bibliotecaadmin.dtos.AutorDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {TextoMapper.class})
public interface AutorMapper {

    AutorDto toDto(AutorEntity autorEntity);

    AutorEntity toEntity(AutorDto autorDto);

}
