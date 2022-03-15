package com.mariots.biblioteca.bibliotecaadmin.exceptions;

import lombok.NoArgsConstructor;

import java.io.IOException;

public class BdException extends RuntimeException {
    public BdException(){
        System.out.println("Error personalizado: Error desde la Base de datos");
    }

}
