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
    String message() default "{org.hibernate.validator.referenceguide.chapter06.CheckCase." +
            "message}";

    String nombreCampoLongitud();

    String nombreCampoTextoString();


}
