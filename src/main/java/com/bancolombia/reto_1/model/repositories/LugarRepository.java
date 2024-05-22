package com.bancolombia.reto_1.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.bancolombia.reto_1.entities.LugarEntity;

import java.util.List;

public interface LugarRepository extends JpaRepository<LugarEntity, Long> {

    public List<LugarEntity> findByNombre(String nombre);

    
    public List<LugarEntity> findByPais(String nombre);
}
