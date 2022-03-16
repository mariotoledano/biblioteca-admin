package com.mariots.biblioteca.bibliotecaadmin.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="textos")
@NoArgsConstructor
@ToString
@Data
public class TextoEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private int idTexto;

    @Column(name="texto")
    private String textoString;

    @Column(name="longitud")
    private String longitud;

    //JOIN TABLES
//!! Reconfigurar para one to one?? REVISAR CASCADE TYPE Y FETCH
    @ManyToMany(fetch=FetchType.LAZY, cascade= {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(name=("texto_autor"),
            joinColumns=@JoinColumn(name="texto_id"),
            inverseJoinColumns=@JoinColumn(name="autor_id"))
    private List<AutorEntity> autores;

    @ManyToMany(fetch=FetchType.LAZY, cascade= {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(name=("texto_tema"),
            joinColumns=@JoinColumn(name="texto_id"),
            inverseJoinColumns=@JoinColumn(name="tema_id"))
    private List<TemaEntity> temas;

    //MÉTODO PARA AGREGAR TEMAS A UN TEXTO BIDIRECCIONAL
    public void addTema(TemaEntity temaEntity){
        //controlamos not null los temas del texto
        if(temas == null){
            temas = new ArrayList<TemaEntity>();
        }
        temas.add(temaEntity);
        //controlamos not null los textos del tema para después agregar texto
        if(temaEntity.getTextos()==null){
            List<TextoEntity> textosDeTema = new ArrayList<>();
            textosDeTema.add(this);
            temaEntity.setTextos(textosDeTema);
            return;
        }
        List<TextoEntity> textosDeTema = temaEntity.getTextos();
        textosDeTema.add(this);
        temaEntity.setTextos(textosDeTema);
    }

    //MÉTODO PARA AGREGAR AUTOR A UN TEXTO BIDIRECCIONAL
    public void addAutor(AutorEntity autorEntity){
        if(temas == null){
            autores= new ArrayList<AutorEntity>();
        }
        autores.add(autorEntity);
        if(autorEntity.getTextos()==null){
            List<TextoEntity> textosDeAutor= new ArrayList<>();
            textosDeAutor.add(this);
            autorEntity.setTextos(textosDeAutor);
            return;
        }
        List<TextoEntity> textosDeAutor = autorEntity.getTextos();
        textosDeAutor.add(this);
        autorEntity.setTextos(textosDeAutor);
    }

    //CONSTRUCTORES
    public TextoEntity(String textoString, String longitud) {
        super();
        this.textoString = textoString;
        this.longitud = longitud;
    }

    public TextoEntity(String textoString, String longitud, List<AutorEntity> autores, List<TemaEntity> temas) {
        this.textoString = textoString;
        this.longitud = longitud;
        this.autores = autores;
        this.temas = temas;
    }

    //GETTERS Y SETTERS
    public int getIdTexto() {
        return idTexto;
    }

    public void setIdTexto(int idTexto) {
        this.idTexto = idTexto;
    }

    public String getTextoString() {
        return textoString;
    }

    public void setTextoString(String textoString) {
        this.textoString = textoString;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public List<AutorEntity> getAutores() {
        return autores;
    }

    public void setAutores(List<AutorEntity> autores) {
        this.autores = autores;
    }

    public List<TemaEntity> getTemas() {
        return temas;
    }

    public void setTemas(List<TemaEntity> temas) {
        this.temas = temas;
    }
}