package com.mariots.biblioteca.bibliotecaadmin.core.dtos.objetosvinculados;

import com.mariots.biblioteca.bibliotecaadmin.core.dtos.TemaDto;
import com.mariots.biblioteca.bibliotecaadmin.core.dtos.TextoDto;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TextoTema {
    private TextoDto textoDto;
    private TemaDto temaDto;
}
