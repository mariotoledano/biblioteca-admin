package com.mariots.biblioteca.bibliotecaadmin.persistence.repository;

import com.mariots.biblioteca.bibliotecaadmin.persistence.entities.TextoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TextoJpaRepository extends JpaRepository<TextoEntity, Integer> {
}
