package com.mariots.biblioteca.bibliotecaadmin.repository;

import com.mariots.biblioteca.bibliotecaadmin.entity.Texto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TextoJpaRepository extends JpaRepository<Texto, Integer> {
}
