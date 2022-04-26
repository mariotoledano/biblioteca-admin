package com.mariots.biblioteca.bibliotecarest.core.dtos.objetosvinculados;

import com.mariots.biblioteca.bibliotecarest.core.dtos.AutorDto;
import com.mariots.biblioteca.bibliotecarest.core.dtos.TextoDto;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TextoAutor {
    private TextoDto textoDto;
    private AutorDto autorDto;
}
