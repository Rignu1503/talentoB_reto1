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
public class LugarRequest {
    @NotBlank(message = "El nombre es requerido")
    private String nombre;
    @NotBlank(message = "EL departamento es requerido")
    private String departamento;
    @NotBlank(message = "El pais es requerido")
    private String pais;
    @NotNull(message = "El ID de la persona es requerido")
    private Long personaID;
}   
