package com.mariots.biblioteca.bibliotecaadmin.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

    @Entity
    @Table(name="autores")
    @ToString
    @NoArgsConstructor
    @Data
    public class Autor {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private int idAutor;
        @Column(name="autor")
        private String nombreAutor;
        @Column(name="fecha_autor")
        private String fechaAutor;
        @Column(name="descripcion_breve")
        private String descripcionBreve;
        @Column(name="descripcion_larga")
        private String descripcionLarga;

        //JOIN TABLE
        @ManyToMany(fetch=FetchType.LAZY, cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                CascadeType.DETACH, CascadeType.REFRESH})
        @JoinTable(name=("texto_autor"),
                joinColumns=@JoinColumn(name="autor_id"),
                inverseJoinColumns=@JoinColumn(name="texto_id"))
        private List<Texto> textos;

        //MÉTODO PARA AGREGAR TEXTOS A UN AUTOR BIDIRECCIONAL
        public void addTexto(Texto texto){
            if(textos == null){
                textos= new ArrayList<Texto>();
            }
            textos.add(texto);
            if(texto.getAutores()==null){
                List<Autor> autoresDeTexto = new ArrayList<>();
                autoresDeTexto.add(this);
                texto.setAutores(autoresDeTexto);
                return;
            }
            List<Autor> autoresDeTexto = texto.getAutores();
            autoresDeTexto.add(this);
            texto.setAutores(autoresDeTexto);

        }

        //CONSTRUCTORES
        public Autor(String nombreAutor, String fechaAutor, String descripcionBreve, String descripcionLarga) {
            super();
            this.nombreAutor = nombreAutor;
            this.fechaAutor = fechaAutor;
            this.descripcionBreve = descripcionBreve;
            this.descripcionLarga = descripcionLarga;
        }

        //GETTERS Y SETTERS
        public int getIdAutor() {
            return idAutor;
        }
        public String getNombreAutor() {
            return nombreAutor;
        }
        public void setNombreAutor(String nombreAutor) {
            this.nombreAutor = nombreAutor;
        }
        public String getFechaAutor() {
            return fechaAutor;
        }
        public void setFechaAutor(String fechaAutor) {
            this.fechaAutor = fechaAutor;
        }
        public String getDescripcionBreve() {
            return descripcionBreve;
        }
        public void setDescripcionBreve(String descripcionBreve) {
            this.descripcionBreve = descripcionBreve;
        }
        public String getDescripcionLarga() {
            return descripcionLarga;
        }
        public void setDescripcionLarga(String descripcionLarga) {
            this.descripcionLarga = descripcionLarga;
        }
        public List<Texto> getTextos() {
            return textos;
        }
        public void setTextos(List<Texto> textos) {
            this.textos = textos;
        }
    }
