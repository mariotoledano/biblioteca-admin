package com.mariots.biblioteca.bibliotecaadmin.persistence.repository;

import com.mariots.biblioteca.bibliotecaadmin.persistence.entities.TemaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemaJpaRepository extends JpaRepository<TemaEntity,Integer> {
}