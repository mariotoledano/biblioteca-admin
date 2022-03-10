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
        @Column
        private String autor;
        @Column
        private String fecha_autor;
        @Column
        private String descripcion_breve;
        @Column
        private String descripcion_larga;

        //CONSTRUCTORES
        public Autor(String autor, String fecha_autor, String descripcion_breve, String descripcion_larga) {
            super();
            this.autor = autor;
            this.fecha_autor = fecha_autor;
            this.descripcion_breve = descripcion_breve;
            this.descripcion_larga = descripcion_larga;
        }


    }
