package com.mariots.biblioteca.bibliotecaadmin.core.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TemaDto {

    int idTema;
    String nombreTema;
    private List<Integer> idTextos;
    private Integer IdSupertema;


}
