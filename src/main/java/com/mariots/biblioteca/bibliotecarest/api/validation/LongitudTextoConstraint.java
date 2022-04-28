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
public @interface LongitudTextoConstraint {
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    String message() default "La longitud del texto no se ajusta a los siguientes estándares: \n" +
            "Texto breve --> Menos de 120 caracteres\n" +
            "Texto largo --> Más de 90 caracteres\n" +
            "O bien no se aportó breve o largo como longitud\n";

    String nombreCampoLongitud();

    String nombreCampoTextoString();


}
