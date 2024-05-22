package com.bancolombia.reto_1.utils.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LugarToPersonaResponse {
    
    private Long idLugar;
    private String nombre;
    private String departamento;
    private String pais;
}
