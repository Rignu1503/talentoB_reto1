package com.bancolombia.reto_1.model.utils.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LugarResponse {
    
    private Long idLugar;
    private String nombre;
    private String departamento;
    private String pais;
    private PersonaToLugarResponse persona;
}
