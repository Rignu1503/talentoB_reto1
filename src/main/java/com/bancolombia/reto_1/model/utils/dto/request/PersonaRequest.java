package com.bancolombia.reto_1.model.utils.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder 
@AllArgsConstructor
@NoArgsConstructor
public class PersonaRequest {
    
    @NotBlank(message = "El nombre es requerido")
    private String nombre;
    @NotNull(message = "La edad es requerida")
    private int edad;
    @NotBlank(message = "La ocupacion es requerido")
    private String ocupacion;
}
