package com.mariots.biblioteca.bibliotecaadmin.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupertemaDto {

    private int idSupertema;
    private String nombreSupertema;
    private List<Integer> idTemas = new ArrayList<>();


}
