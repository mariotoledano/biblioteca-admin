package com.mariots.biblioteca.bibliotecaadmin.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "supertemas")
@NoArgsConstructor
@ToString
@Data
public class SupertemaEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private int idSupertema;

    @Column(name = "supertema")
    private String nombreSupertema;

    //SUPERTEMA->TEMAS ONE TO MANY
    @OneToMany(mappedBy = "supertema")
    private List<TemaEntity> temas = new ArrayList<>();

    //MÉTODO PARA AGREGAR TEMAS A UN SUPERTEMA BIDIRECCIONAL
    public void addTema(TemaEntity temaEntity){
        if(temas == null){
            temas = new ArrayList<TemaEntity>();
        }
        temas.add(temaEntity);
        temaEntity.setSupertema(this);
    }

    //CONSTRUCTORES
    public SupertemaEntity(String nombreSupertema) {
        this.nombreSupertema = nombreSupertema;
    }

    public int getIdSupertema() {
        return idSupertema;
    }

    public String getNombreSupertema() {
        return nombreSupertema;
    }

    public void setNombreSupertema(String nombreSupertema) {
        this.nombreSupertema = nombreSupertema;
    }

    public List<TemaEntity> getTemas() {
        return temas;
    }

    public void setTemas(List<TemaEntity> temas) {
        this.temas = temas;
    }
}