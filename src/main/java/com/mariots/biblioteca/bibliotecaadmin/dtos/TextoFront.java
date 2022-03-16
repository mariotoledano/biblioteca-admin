package com.mariots.biblioteca.bibliotecaadmin.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@Data
public class TextoFront {

    private String textoString;
    private String longitud;
    private int idAutor;
    private int idTema;

}
