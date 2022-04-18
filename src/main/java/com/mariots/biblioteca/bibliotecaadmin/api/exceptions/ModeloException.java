package com.mariots.biblioteca.bibliotecaadmin.api.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;


import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ModeloException{
    private LocalDateTime fechaYHora;
    private String mensaje;
    private String detalles;
}
