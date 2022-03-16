package com.mariots.biblioteca.bibliotecaadmin.repository;

import com.mariots.biblioteca.bibliotecaadmin.entities.TextoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TextoJpaRepository extends JpaRepository<TextoEntity, Integer> {
}
