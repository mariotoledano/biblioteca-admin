package com.mariots.biblioteca.bibliotecaadmin.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "supertemas")
public class SupertemaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int idSupertema;

    @Column(name = "supertema")
    private String nombreSupertema;

    //SUPERTEMA->TEMAS ONE TO MANY
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH}, mappedBy = "supertema")
    private List<TemaEntity> temas = new ArrayList<>();


}