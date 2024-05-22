package com.bancolombia.reto_1.model.utils.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class PersonaToLugarResponse {
    
    private Long idPersona;
    private String nombre;
    private int edad;
    private String ocupacion;
}
