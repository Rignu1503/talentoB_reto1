package com.bancolombia.reto_1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bancolombia.reto_1.entities.PersonaEntity;

public interface PersonaRepository extends JpaRepository<PersonaEntity, Long>{
    
}
