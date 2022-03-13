package com.mariots.biblioteca.bibliotecaadmin.model;

import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="textos")
@NoArgsConstructor
@ToString
public class Texto {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="texto")
    private String textoString;

    @Column(name="longitud")
    private String longitud;

    //JOIN TABLES
//!! Reconfigurar para one to one?? REVISAR CASCADE TYPE Y FETCH
    @ManyToMany(fetch=FetchType.EAGER, cascade= {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(name=("texto_autor"),
            joinColumns=@JoinColumn(name="texto_id"),
            inverseJoinColumns=@JoinColumn(name="autor_id"))
    private List<Autor> autores;

    @ManyToMany(fetch=FetchType.LAZY, cascade= {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(name=("texto_tema"),
            joinColumns=@JoinColumn(name="texto_id"),
            inverseJoinColumns=@JoinColumn(name="tema_id"))
    private List<Tema> temas;

    //MÉTODO PARA AGREGAR TEMAS A UN TEXTO BIDIRECCIONAL
    public void addTema(Tema tema){
        //controlamos not null los temas del texto
        if(temas == null){
            temas= new ArrayList<Tema>();
        }
        temas.add(tema);
        //controlamos not null los textos del tema para después agregar texto
        if(tema.getTextos()==null){
            List<Texto> textosDeTema = new ArrayList<>();
            textosDeTema.add(this);
            tema.setTextos(textosDeTema);
            return;
        }
        List<Texto> textosDeTema = tema.getTextos();
        textosDeTema.add(this);
        tema.setTextos(textosDeTema);
    }

    //MÉTODO PARA AGREGAR AUTOR A UN TEXTO BIDIRECCIONAL
    public void addAutor(Autor autor){
        if(temas == null){
            autores= new ArrayList<Autor>();
        }
        autores.add(autor);
        if(autor.getTextos()==null){
            List<Texto> textosDeAutor= new ArrayList<>();
            textosDeAutor.add(this);
            autor.setTextos(textosDeAutor);
            return;
        }
        List<Texto> textosDeAutor = autor.getTextos();
        textosDeAutor.add(this);
        autor.setTextos(textosDeAutor);
    }

    //CONSTRUCTORES
    public Texto(String textoString, String longitud) {
        super();
        this.textoString = textoString;
        this.longitud = longitud;
    }


    //GETTERS Y SETTERS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public List<Tema> getTemas() {
        return temas;
    }

    public void setTemas(List<Tema> temas) {
        this.temas = temas;
    }
}