package com.bancolombia.reto_1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bancolombia.reto_1.services.PersonaService;
import com.bancolombia.reto_1.utils.dto.request.PersonaRequest;
import com.bancolombia.reto_1.utils.dto.response.PersonaResponse;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/persona")
@AllArgsConstructor
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @PostMapping
    public ResponseEntity<PersonaResponse> createPersona(
        @Validated @RequestBody PersonaRequest persona
    ) {
    
        return ResponseEntity.ok(this.personaService.create(persona));
    }
    
}
