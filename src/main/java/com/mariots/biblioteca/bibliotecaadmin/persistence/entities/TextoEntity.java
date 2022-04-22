package com.mariots.biblioteca.bibliotecaadmin.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "textos")
public class TextoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int idTexto;
    @Column(name = "texto", nullable = false)
    private String textoString;

    @Column(name = "longitud")
    private String longitud;

    //JOIN TABLES

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "autor_id")
    private AutorEntity autor;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(name = ("texto_tema"),
            joinColumns = @JoinColumn(name = "texto_id"),
            inverseJoinColumns = @JoinColumn(name = "tema_id"))
    private List<TemaEntity> temas;

}