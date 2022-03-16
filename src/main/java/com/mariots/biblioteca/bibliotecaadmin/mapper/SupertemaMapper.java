package com.mariots.biblioteca.bibliotecaadmin.mapper;

import com.mariots.biblioteca.bibliotecaadmin.entities.SupertemaEntity;
import com.mariots.biblioteca.bibliotecaadmin.dtos.SupertemaDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {TemaMapper.class})
public interface SupertemaMapper {

    SupertemaDto toDto(SupertemaEntity supertema);

    SupertemaEntity toEntity(SupertemaDto supertemaDto);

}
