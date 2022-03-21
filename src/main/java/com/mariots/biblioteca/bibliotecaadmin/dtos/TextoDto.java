package com.mariots.biblioteca.bibliotecaadmin.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TextoDto {
    private int idTexto;
    private String textoString;
    private String longitud;
    private Integer idAutor;
    private List<Integer> idTemas;

    public TextoDto(String textoString, String longitud, Integer idAutor, List<Integer> idTemas) {
        this.textoString = textoString;
        this.longitud = longitud;
        this.idAutor = idAutor;
        this.idTemas = idTemas;
    }
}
