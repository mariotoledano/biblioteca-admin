package com.mariots.biblioteca.bibliotecarest.api.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = LongitudTextoValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface LongitudTextoConstraint {
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    String message() default "La longitud del texto no se ajusta a los siguientes estándares:" +
            "Texto breve --> Menos de 120 caracteres" +
            "Texto largo --> Más de 90 caracteres" +
            "O bien no se aportó breve o largo como longitud";

    String nombreCampoLongitud();

    String nombreCampoTextoString();


}
