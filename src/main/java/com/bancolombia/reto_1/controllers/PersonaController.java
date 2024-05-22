package com.bancolombia.reto_1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bancolombia.reto_1.model.services.PersonaService;
import com.bancolombia.reto_1.model.utils.dto.request.PersonaRequest;
import com.bancolombia.reto_1.model.utils.dto.response.PersonaResponse;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/persona")
@AllArgsConstructor
public class PersonaController {

    @Autowired
    private PersonaService personaService;

     @Operation(summary = "Crear persona", description = "TEST")
    @PostMapping
    public ResponseEntity<PersonaResponse> createPersona(
        @Validated @RequestBody PersonaRequest persona
    ) {
    
        return ResponseEntity.ok(this.personaService.create(persona));
    }
    
}
