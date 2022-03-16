package com.mariots.biblioteca.bibliotecaadmin.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
@Data
@NoArgsConstructor
public class SupertemaDto {

    private int idSupertema;
    private String nombreSupertema;
    private List<TemaDto> temas = new ArrayList<>();

}
