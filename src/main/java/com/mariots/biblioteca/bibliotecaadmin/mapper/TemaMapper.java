package com.mariots.biblioteca.bibliotecaadmin.mapper;

import com.mariots.biblioteca.bibliotecaadmin.entities.TemaEntity;
import com.mariots.biblioteca.bibliotecaadmin.dtos.TemaDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {TextoMapper.class, AutorMapper.class, SupertemaMapper.class})
public interface TemaMapper {

    @Mapping(source = "temaEntity.supertemas.idSupertema", target = "idSupertemas")
    @Mapping(source = "temaEntity.textos.idTexto", target = "idTextos")
    TemaDto toDto(TemaEntity temaEntity);

    @InheritInverseConfiguration
    TemaEntity toEntity(TemaDto temaDto);
}
