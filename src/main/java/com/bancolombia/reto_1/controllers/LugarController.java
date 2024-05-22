package com.bancolombia.reto_1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bancolombia.reto_1.model.services.LugarService;
import com.bancolombia.reto_1.model.utils.dto.request.LugarRequest;
import com.bancolombia.reto_1.model.utils.dto.response.LugarResponse;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;

@Controller
@RequestMapping(path = "/lugar")
@AllArgsConstructor
public class LugarController {

    @Autowired
    private LugarService lugarService;

    @Operation(summary = "Mostrar todos los datos de la entidad", description = "TEST")
    @GetMapping
    public ResponseEntity<Page<LugarResponse>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {

        return ResponseEntity.ok(lugarService.getAll(page - 1, size));
    }

    @Operation(summary = "Consultar personas que hayan visitado un lugar especifico", description = "TEST")
    @GetMapping("/{nombre}")
    public ResponseEntity<List<LugarResponse>> getByName(
            @PathVariable String nombre) {

        return ResponseEntity.ok(lugarService.findByName(nombre));
    }

    @Operation(summary = "Consultar lugares visitados de un país especifico", description = "TEST")
    @GetMapping("/pais/{pais}")
    public ResponseEntity<List<LugarResponse>> findByPais(
            @PathVariable String pais) {

        return ResponseEntity.ok(lugarService.findByPais(pais));
    }

    @Operation(summary = "Consultar lugares visitados de un país especifico", description = "TEST")
    @PostMapping
    public ResponseEntity<LugarResponse> createLugar(
            @Validated @RequestBody LugarRequest lugar) {

        return ResponseEntity.ok(this.lugarService.create(lugar));
   
    }
    
}
