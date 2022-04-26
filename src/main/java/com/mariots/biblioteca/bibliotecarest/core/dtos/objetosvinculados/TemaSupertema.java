package com.mariots.biblioteca.bibliotecarest.core.dtos.objetosvinculados;

import com.mariots.biblioteca.bibliotecarest.core.dtos.SupertemaDto;
import com.mariots.biblioteca.bibliotecarest.core.dtos.TemaDto;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TemaSupertema {
    private TemaDto tema;
    private SupertemaDto supertema;
}
