package com.mariots.biblioteca.bibliotecarest.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class LongitudYTextoNoConcuerdanException extends RuntimeException{
    public LongitudYTextoNoConcuerdanException(){
        super("La longitud del texto aportado y el valor del campo longitud no concuerdan" +
                "Longitud breve --> menos de 120 caracteres" +
                "Longitud largo -->más de 90 caracteres");
    }
}
