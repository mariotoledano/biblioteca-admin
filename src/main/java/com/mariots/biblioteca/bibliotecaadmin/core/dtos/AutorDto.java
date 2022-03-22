package com.mariots.biblioteca.bibliotecaadmin.core.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AutorDto {

    private int idAutor;
    private String nombreAutor;
    private String fechaAutor;
    private String descripcionBreve;
    private String descripcionLarga;
    private List<Integer> idTextos;

}
