package com.mariots.biblioteca.bibliotecaadmin.model;

import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="temas")
@NoArgsConstructor
@ToString
public class Tema {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    int idTema;
    @Column(name="tema")
    String nombreTema;
    //JOIN TABLE TEXTO_TEMA
    @ManyToMany(fetch=FetchType.LAZY, cascade= {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(name=("texto_tema"),
            joinColumns=@JoinColumn(name="tema_id"),
            inverseJoinColumns=@JoinColumn(name="texto_id"))
    private List<Texto> textos;

    //TEMAS -> SUPERTEMA MANY TO ONE
    @ManyToOne(fetch=FetchType.LAZY, cascade= {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name=("supertema_id"))
    private Supertema supertema;

    //MÉTODO PARA AGREGAR TEXTOS A UN TEMA BIDIRECCIONAL
    public void addTexto(Texto texto){
        if(textos == null){
            textos= new ArrayList<Texto>();
        }
        textos.add(texto);
        if(texto.getTemas()==null){
            List<Tema> temasDeTexto = new ArrayList<>();
            temasDeTexto.add(this);
            texto.setTemas(temasDeTexto);
            return;
        }
        List<Tema> temasDeTexto = texto.getTemas();
        temasDeTexto.add(this);
        texto.setTemas(temasDeTexto);
    }

    //CONSTRUCTORES
    public Tema(String nombreTema, Supertema supertema) {
        super();
        this.nombreTema = nombreTema;
        this.supertema = supertema;
    }

    //GETTERS Y SETTERS
    public int getIdTema() {
        return idTema;
    }
    public String getNombreTema() {
        return nombreTema;
    }
    public void setNombreTema(String nombreTema) {
        this.nombreTema = nombreTema;
    }
    public Supertema getSupertema() {return supertema;}
    public void setSupertema(Supertema supertema) {this.supertema = supertema;	}
    public List<Texto> getTextos() {
        return textos;
    }
    public void setTextos(List<Texto> textos) {
        this.textos = textos;
    }

}