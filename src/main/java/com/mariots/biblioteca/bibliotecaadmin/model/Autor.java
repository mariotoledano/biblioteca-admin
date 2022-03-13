package com.mariots.biblioteca.bibliotecaadmin.model;

import lombok.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

    @Entity
    @Table(name="autores" )
    // A shortcut for @ToString, @EqualsAndHashCode, @Getter on all fields, and @Setter on all non-final fields, and @RequiredArgsConstructor
    @Data
    @NoArgsConstructor
    public class Autor {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", nullable = false)
        private int id;
        @Column(name="autor")
        private String nombreAutor;
        @Column(name="fecha_autor")
        private String fechaAutor;
        @Column(name="descripcion_breve")
        private String descripcionBreve;
        @Column(name="descripcion_larga")
        private String descripcionLarga;

        //CONSTRUCTORES
        public Autor(String nombreAutor, String fechaAutor, String descripcionBreve, String descripcionLarga) {
            super();
            this.nombreAutor = nombreAutor;
            this.fechaAutor = fechaAutor;
            this.descripcionBreve = descripcionBreve;
            this.descripcionLarga = descripcionLarga;
        }


    }
