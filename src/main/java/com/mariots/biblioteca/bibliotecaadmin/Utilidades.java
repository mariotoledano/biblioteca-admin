package com.mariots.biblioteca.bibliotecaadmin;

import com.google.gson.Gson;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Component
public class Utilidades {

    public String objetoAJson(Object objeto){
        return new Gson().toJson(objeto);
    }
}
