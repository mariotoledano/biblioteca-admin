package com.mariots.biblioteca.bibliotecaadmin.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="temas")
@NoArgsConstructor
@ToString
@Data
public class TemaEntity {

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
    private List<TextoEntity> textos;

    //TEMAS -> SUPERTEMA MANY TO ONE
    @ManyToOne(fetch=FetchType.LAZY, cascade= {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name=("supertema_id"))
    private SupertemaEntity supertema;

    //MÉTODO PARA AGREGAR TEXTOS A UN TEMA BIDIRECCIONAL
    public void addTexto(TextoEntity textoEntity){
        if(textos == null){
            textos = new ArrayList<TextoEntity>();
        }
        textos.add(textoEntity);
        if(textoEntity.getTemas()==null){
            List<TemaEntity> temasDeTexto = new ArrayList<>();
            temasDeTexto.add(this);
            textoEntity.setTemas(temasDeTexto);
            return;
        }
        List<TemaEntity> temasDeTexto = textoEntity.getTemas();
        temasDeTexto.add(this);
        textoEntity.setTemas(temasDeTexto);
    }

    //CONSTRUCTORES
    public TemaEntity(String nombreTema, SupertemaEntity supertema) {
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
    public SupertemaEntity getSupertema() {return supertema;}
    public void setSupertema(SupertemaEntity supertema) {this.supertema = supertema;	}
    public List<TextoEntity> getTextos() {
        return textos;
    }
    public void setTextos(List<TextoEntity> textos) {
        this.textos = textos;
    }

}