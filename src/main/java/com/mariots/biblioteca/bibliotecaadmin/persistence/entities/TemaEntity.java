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
@Table(name="temas")
public class TemaEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    int idTema;
    @NotNull
    @Column(name="tema", unique = true)
    String nombreTema;

    //TEXTO -> TEMA MANY TO MANY
    @ManyToMany(fetch=FetchType.LAZY, cascade= {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(name=("texto_tema"),
            joinColumns=@JoinColumn(name="tema_id"),
            inverseJoinColumns=@JoinColumn(name="texto_id"))
    private List<TextoEntity> textos;

    //TEMAS -> SUPERTEMA MANY TO ONE
    @ManyToOne(fetch=FetchType.LAZY, cascade= {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name=("supertema_id"))
    private SupertemaEntity supertema;


}