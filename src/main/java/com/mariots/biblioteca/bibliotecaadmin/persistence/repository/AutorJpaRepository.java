package com.mariots.biblioteca.bibliotecaadmin.persistence.repository;

import com.mariots.biblioteca.bibliotecaadmin.persistence.entities.AutorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorJpaRepository extends JpaRepository<AutorEntity,Integer> {
}
