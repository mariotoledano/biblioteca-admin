package com.mariots.biblioteca.bibliotecaadmin.mapper;

import com.mariots.biblioteca.bibliotecaadmin.entities.AutorEntity;
import com.mariots.biblioteca.bibliotecaadmin.dtos.AutorDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {TemaMapper.class, TextoMapper.class, SupertemaMapper.class})
public interface AutorMapper {

    @Mapping(source = "autorEntity.textos.idTexto", target = "idTextos")
    AutorDto toDto(AutorEntity autorEntity);

    @InheritInverseConfiguration
    AutorEntity toEntity(AutorDto autorDto);

}
