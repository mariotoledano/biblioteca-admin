package com.mariots.biblioteca.bibliotecaadmin.mapper;

import com.mariots.biblioteca.bibliotecaadmin.entities.TextoEntity;
import com.mariots.biblioteca.bibliotecaadmin.dtos.TextoDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {TemaMapper.class, AutorMapper.class, SupertemaMapper.class})
public interface TextoMapper {
    @Mapping(source = "textoEntity.temas.idtema", target = "idTemas")
    @Mapping(source = "textoEntity.textos.idtexto", target = "idAutores")
    TextoDto toDto(TextoEntity textoEntity);
    @InheritInverseConfiguration
    TextoEntity toEntity(TextoDto textoDto);


}
