package com.mariots.biblioteca.bibliotecaadmin.model;

import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "supertemas")
@NoArgsConstructor
@ToString
public class Supertema {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "supertema")
    private String nombreSupertema;

    //SUPERTEMA->TEMAS ONE TO MANY
    @OneToMany(mappedBy = "supertema")
    private List<Tema> temas = new ArrayList<>();

    //MÉTODO PARA AGREGAR TEMAS A UN SUPERTEMA BIDIRECCIONAL
    public void addTema(Tema tema){
        if(temas == null){
            temas= new ArrayList<Tema>();
        }
        temas.add(tema);
        tema.setSupertema(this);
    }

    //CONSTRUCTORES
    public Supertema(String nombreSupertema) {
        this.nombreSupertema = nombreSupertema;
    }

    public int getId() {
        return id;
    }

    public String getNombreSupertema() {
        return nombreSupertema;
    }

    public void setNombreSupertema(String nombreSupertema) {
        this.nombreSupertema = nombreSupertema;
    }

    public List<Tema> getTemas() {
        return temas;
    }

    public void setTemas(List<Tema> temas) {
        this.temas = temas;
    }
}