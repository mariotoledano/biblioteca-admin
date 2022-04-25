package com.mariots.biblioteca.bibliotecaadmin.core.dtos.objetosvinculados;

import com.mariots.biblioteca.bibliotecaadmin.core.dtos.AutorDto;
import com.mariots.biblioteca.bibliotecaadmin.core.dtos.TextoDto;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TextoAutor {
    private TextoDto textoDto;
    private AutorDto autorDto;
}
