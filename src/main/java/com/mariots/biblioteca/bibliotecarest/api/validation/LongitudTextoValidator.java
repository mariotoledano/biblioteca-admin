package com.mariots.biblioteca.bibliotecarest.api.validation;

import com.mariots.biblioteca.bibliotecarest.api.exceptions.LongitudYTextoNoConcuerdanException;
import org.springframework.beans.BeanWrapperImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class LongitudTextoValidator
        implements ConstraintValidator<LongitudTextoConstraint, Object> {

    private String longitud;
    private String textoString;

    public void initialize(LongitudTextoConstraint constraintAnnotation) {
        this.longitud = constraintAnnotation.nombreCampoLongitud();
        this.textoString = constraintAnnotation.nombreCampoTextoString();
    }
    @Override
    public boolean isValid(Object textoModel,
                           ConstraintValidatorContext context) {
        context.disableDefaultConstraintViolation();
        String valorLongitud = (String) new BeanWrapperImpl(textoModel)
                .getPropertyValue(longitud);
        String valorTextoString = (String) new BeanWrapperImpl(textoModel)
                .getPropertyValue(textoString);

        if(valorLongitud.equals("breve")&& valorTextoString.length()>=120){
            throw new LongitudYTextoNoConcuerdanException();
        }

        if (valorLongitud.equals("largo")&&valorTextoString.length()<=90) {
            throw new LongitudYTextoNoConcuerdanException();
        }
        return true;
    }

}
