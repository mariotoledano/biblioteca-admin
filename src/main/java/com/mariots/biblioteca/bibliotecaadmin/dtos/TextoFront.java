package com.mariots.biblioteca.bibliotecaadmin.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TextoFront {

    private String textoString;
    private String longitud;
    private int idAutor;
    private int idTema;

}
