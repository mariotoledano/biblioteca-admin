package com.mariots.biblioteca.bibliotecaadmin.mapper;

import com.mariots.biblioteca.bibliotecaadmin.entities.TemaEntity;
import com.mariots.biblioteca.bibliotecaadmin.dtos.TemaDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {SupertemaMapper.class, TextoMapper.class})
public interface TemaMapper {

    TemaDto toDto(TemaEntity temaEntity);

    TemaEntity toEntity(TemaDto temaDto);
}
