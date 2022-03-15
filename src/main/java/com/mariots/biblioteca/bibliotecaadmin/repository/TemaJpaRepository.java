package com.mariots.biblioteca.bibliotecaadmin.repository;

import com.mariots.biblioteca.bibliotecaadmin.entity.Tema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemaJpaRepository extends JpaRepository<Tema,Integer> {
}