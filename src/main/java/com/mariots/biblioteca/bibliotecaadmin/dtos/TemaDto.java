package com.mariots.biblioteca.bibliotecaadmin.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@ToString
@Data
@NoArgsConstructor
public class TemaDto {

    int idTema;
    String nombreTema;
    private List<TextoDto> textos;
    private SupertemaDto supertema;
}
