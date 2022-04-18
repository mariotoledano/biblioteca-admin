package com.mariots.biblioteca.bibliotecaadmin.persistence.repository;

import com.mariots.biblioteca.bibliotecaadmin.persistence.entities.SupertemaEntity;
import com.mariots.biblioteca.bibliotecaadmin.persistence.entities.TemaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface SupertemaJpaRepository extends JpaRepository<SupertemaEntity, Integer> {
    @Query
    Optional<SupertemaEntity> findByNombreSupertema(String nombreSupertema);
}
