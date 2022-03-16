package com.mariots.biblioteca.bibliotecaadmin.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@ToString
@Data
@NoArgsConstructor
public class AutorDto {
    private int idAutor;
    private String nombreAutor;
    private String fechaAutor;
    private String descripcionBreve;
    private String descripcionLarga;
    private List<TextoDto> textos;
}
