package com.mariots.biblioteca.bibliotecaadmin.exceptions;

public class BdException extends RuntimeException {
    public BdException(){
        System.out.println("Error personalizado: Error desde la Base de datos");
    }

}
