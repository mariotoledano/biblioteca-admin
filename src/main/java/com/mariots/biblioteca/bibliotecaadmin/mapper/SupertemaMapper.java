package com.mariots.biblioteca.bibliotecaadmin.mapper;

import com.mariots.biblioteca.bibliotecaadmin.entities.SupertemaEntity;
import com.mariots.biblioteca.bibliotecaadmin.dtos.SupertemaDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {TemaMapper.class, AutorMapper.class, TextoMapper.class})
public interface SupertemaMapper {
    @Mapping(source = "supertemaEntity.temas.idTema", target = "idTemas")
    SupertemaDto toDto(SupertemaEntity supertemaEntity);
    @InheritInverseConfiguration
    SupertemaEntity toEntity(SupertemaDto supertemaDto);

}
