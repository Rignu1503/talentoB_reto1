package com.bancolombia.reto_1.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "lugar")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LugarEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLugar;
     @Column(length = 40, nullable = false)
    private String nombre;
    @Column(length = 40, nullable = false)
    private String departamento;
    @Column(length = 40, nullable = false)
    private String pais;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personaIdPersona" ,referencedColumnName = "idPersona")
    private PersonaEntity persona;
}
