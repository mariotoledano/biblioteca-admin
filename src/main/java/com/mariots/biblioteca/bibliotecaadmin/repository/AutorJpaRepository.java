package com.mariots.biblioteca.bibliotecaadmin.repository;

import com.mariots.biblioteca.bibliotecaadmin.entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorJpaRepository extends JpaRepository<Autor,Integer> {
}
