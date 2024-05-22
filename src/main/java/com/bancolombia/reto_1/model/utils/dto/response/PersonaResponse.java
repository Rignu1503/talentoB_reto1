package com.bancolombia.reto_1.model.utils.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonaResponse {
    
    private Long idPersona;
    private String nombre;
    private int edad;
    private String ocupacion;
    private List<LugarToPersonaResponse> lugar;
    
}
