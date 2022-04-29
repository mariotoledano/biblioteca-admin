package com.mariots.biblioteca.bibliotecarest.api.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = LongitudTextoValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface RestriccionesTexto {
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String message() default "Error de validación de Texto";

    String nombreCampoLongitud();

    String nombreCampoTextoString();


}
