package com.mariots.biblioteca.bibliotecarest.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.OK)
public class NoHayResultadosException extends RuntimeException {
    public NoHayResultadosException(){
        super("No existen resultados para esta búsqueda");
    }
    public NoHayResultadosException(String mensajePersonalizado){
        super(mensajePersonalizado);
    }
}
