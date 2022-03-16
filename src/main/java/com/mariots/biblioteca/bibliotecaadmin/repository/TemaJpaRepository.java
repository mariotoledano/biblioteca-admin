package com.mariots.biblioteca.bibliotecaadmin.repository;

import com.mariots.biblioteca.bibliotecaadmin.entities.TemaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemaJpaRepository extends JpaRepository<TemaEntity,Integer> {
}