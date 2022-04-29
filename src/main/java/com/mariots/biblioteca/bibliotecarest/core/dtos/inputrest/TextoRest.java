package com.mariots.biblioteca.bibliotecarest.core.dtos.inputrest;

import com.mariots.biblioteca.bibliotecarest.api.validation.RestriccionesTexto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@RestriccionesTexto(nombreCampoLongitud = "longitud", nombreCampoTextoString = "textoString")
public class TextoRest {

    private String textoString;
    private String longitud;
    private String nombreAutor;
    private List<String> nombreTemas;
}
