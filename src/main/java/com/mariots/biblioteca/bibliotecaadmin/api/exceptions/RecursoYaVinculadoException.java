package com.mariots.biblioteca.bibliotecaadmin.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RecursoYaVinculadoException extends RuntimeException{
    public RecursoYaVinculadoException(){
        super("Ya existe un vínculo. Use la opción de /sobreescribir si lo desea.");
    }
    public RecursoYaVinculadoException(String mensajePersonalizado){
        super(mensajePersonalizado);
    }
}
