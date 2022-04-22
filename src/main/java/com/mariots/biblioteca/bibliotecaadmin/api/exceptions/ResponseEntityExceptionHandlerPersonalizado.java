package com.mariots.biblioteca.bibliotecaadmin.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ResponseEntityExceptionHandlerPersonalizado extends ResponseEntityExceptionHandler {
    //Excepción lanzada como respuesta Rest en caso de una excepción genérica no especificada
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> respuestaGenericaExcepcion(Exception ex, WebRequest request) {
        ModeloException modeloException = new ModeloException(LocalDateTime.now(),ex.getMessage(), request.getDescription(true));
        return new ResponseEntity(modeloException, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(RecursoNoEncontradoException.class)
    public final ResponseEntity<ModeloException> respuestaRecursoNoEncontrado(RecursoNoEncontradoException ex, WebRequest request){
        ModeloException modeloException = new ModeloException(LocalDateTime.now(),ex.getMessage(), request.getDescription(true));
        return new ResponseEntity(modeloException, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(CampoEnBlancoException.class)
    public final ResponseEntity<ModeloException> respuestaCampoEnBlancoException(RecursoNoEncontradoException ex, WebRequest request){
        ModeloException modeloException = new ModeloException(LocalDateTime.now(),ex.getMessage(), request.getDescription(true));
        return new ResponseEntity(modeloException, HttpStatus.BAD_REQUEST);
    }

}