package com.mariots.biblioteca.bibliotecaadmin.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RecursoNoVinculadoException extends RuntimeException{
    public RecursoNoVinculadoException(){
        super("No existe ningún vínculo previo. No utilice la opción /sobreescribir si desea crear un vínculo nuevo.");
    }
}
