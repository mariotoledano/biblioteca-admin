package com.mariots.biblioteca.bibliotecaadmin.core.dtos.nuevorest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NuevoTextoRest {

    private String textoString;
    private String longitud;
    private String nombreAutor;
    private List<String> nombreTemas;
}
