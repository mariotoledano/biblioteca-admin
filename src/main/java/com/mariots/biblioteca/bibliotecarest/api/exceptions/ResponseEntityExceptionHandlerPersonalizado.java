package com.mariots.biblioteca.bibliotecarest.api.exceptions;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ResponseEntityExceptionHandlerPersonalizado extends ResponseEntityExceptionHandler {
//    //Excepción lanzada como respuesta Rest en caso de una excepción genérica no especificada
//    @Order
//    @ExceptionHandler(value = Exception.class)
//    public final ResponseEntity<Object> respuestaGenericaExcepcion(Exception ex, WebRequest request) {
//        ModeloException modeloException = ModeloException.builder()
//                .fechaYHora(LocalDateTime.now())
//                .mensaje(ex.getMessage())
//                .detalles(request.getDescription(true))
//                .build();
//        return new ResponseEntity(modeloException, HttpStatus.INTERNAL_SERVER_ERROR);
//    }

    @ExceptionHandler(RecursoNoEncontradoException.class)
    public final ResponseEntity<ModeloException> respuestaRecursoNoEncontrado(RecursoNoEncontradoException ex, WebRequest request){
        ModeloException modeloException = ModeloException.builder()
                .fechaYHora(LocalDateTime.now())
                .mensaje(ex.getMessage())
                .detalles(request.getDescription(true))
                .build();
        return new ResponseEntity(modeloException, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CampoEnBlancoException.class)
    public final ResponseEntity<ModeloException> respuestaCampoEnBlancoException(CampoEnBlancoException ex, WebRequest request){
        ModeloException modeloException = ModeloException.builder()
                .fechaYHora(LocalDateTime.now())
                .mensaje(ex.getMessage())
                .detalles(request.getDescription(true))
                .build();
        return new ResponseEntity(modeloException, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RecursoYaVinculadoException.class)
    public final ResponseEntity<ModeloException> respuestaRecursoYaVinculadoException(RecursoYaVinculadoException ex, WebRequest request){
        ModeloException modeloException = ModeloException.builder()
                .fechaYHora(LocalDateTime.now())
                .mensaje(ex.getMessage())
                .detalles(request.getDescription(true))
                .build();
        return new ResponseEntity(modeloException, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RecursoNoVinculadoException.class)
    public final ResponseEntity<ModeloException> respuestaRecursoNoVinculadoException(RecursoNoVinculadoException ex, WebRequest request){
        ModeloException modeloException = ModeloException.builder()
                .fechaYHora(LocalDateTime.now())
                .mensaje(ex.getMessage())
                .detalles(request.getDescription(true))
                .build();
        return new ResponseEntity(modeloException, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RepetirVinculoException.class)
    public final ResponseEntity<ModeloException> respuestaRepetirVinculoException(RepetirVinculoException ex, WebRequest request){
        ModeloException modeloException = ModeloException.builder()
                .fechaYHora(LocalDateTime.now())
                .mensaje(ex.getMessage())
                .detalles(request.getDescription(true))
                .build();
        return new ResponseEntity(modeloException, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoHayResultadosException.class)
    public final ResponseEntity<ModeloException> respuestaNoHayResultadosException(NoHayResultadosException ex, WebRequest request){
        ModeloException modeloException = ModeloException.builder()
                .fechaYHora(LocalDateTime.now())
                .mensaje(ex.getMessage())
                .detalles(request.getDescription(true))
                .build();
        return new ResponseEntity(modeloException, HttpStatus.OK);
    }

    @ExceptionHandler(DuplicarRecursoException.class)
    public final ResponseEntity<ModeloException> respuestaDuplicarRecursoException(DuplicarRecursoException ex, WebRequest request){
        ModeloException modeloException = ModeloException.builder()
                .fechaYHora(LocalDateTime.now())
                .mensaje(ex.getMessage())
                .detalles(request.getDescription(true))
                .build();
        return new ResponseEntity(modeloException, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(LongitudYTextoNoConcuerdanException.class)
    public final ResponseEntity<ModeloException> respuestaLongitudYTextoNoConcuerdanException(LongitudYTextoNoConcuerdanException ex, WebRequest request){
        ModeloException modeloException = ModeloException.builder()
                .fechaYHora(LocalDateTime.now())
                .mensaje(ex.getMessage())
                .detalles(request.getDescription(true))
                .build();
        return new ResponseEntity(modeloException, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public final ResponseEntity<ModeloException> respuestaConstraintViolationException(ConstraintViolationException ex, WebRequest request){
        ModeloException modeloException = ModeloException.builder()
                .fechaYHora(LocalDateTime.now())
                .mensaje(ex.getMessage())
                .detalles(request.getDescription(true))
                .build();
        return new ResponseEntity(modeloException, HttpStatus.BAD_REQUEST);
    }

//    @Order(value = Ordered.HIGHEST_PRECEDENCE )
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public final ResponseEntity<ModeloException> respuestaMethodArgumentNotValidException(MethodArgumentNotValidException ex, WebRequest request){
//        ModeloException modeloException = ModeloException.builder()
//                .fechaYHora(LocalDateTime.now())
//                .mensaje(ex.getMessage())
//                .detalles(request.getDescription(true))
//                .build();
//        return new ResponseEntity(modeloException, HttpStatus.BAD_REQUEST);
//    }

    @Order(value = Ordered.HIGHEST_PRECEDENCE)
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ModeloException modeloException = ModeloException.builder()
                .fechaYHora(LocalDateTime.now())
                .mensaje(ex.getMessage())
                .detalles(request.getDescription(true))
                .build();
        return new ResponseEntity(modeloException, HttpStatus.BAD_REQUEST);
    }

}
