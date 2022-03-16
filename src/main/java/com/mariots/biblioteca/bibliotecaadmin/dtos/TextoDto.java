package com.mariots.biblioteca.bibliotecaadmin.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@ToString
@Data
@NoArgsConstructor
public class TextoDto {
    private int idTexto;
    private String textoString;
    private String longitud;
    private List<AutorDto> autores;
    private List<TemaDto> temas;

    public TextoDto(String textoString, String longitud, List<AutorDto> autores, List<TemaDto> temas) {
        this.textoString = textoString;
        this.longitud = longitud;
        this.autores = autores;
        this.temas = temas;
    }
}
