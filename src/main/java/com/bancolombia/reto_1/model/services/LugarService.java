package com.bancolombia.reto_1.model.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.bancolombia.reto_1.entities.LugarEntity;
import com.bancolombia.reto_1.entities.PersonaEntity;
import com.bancolombia.reto_1.model.repositories.LugarRepository;
import com.bancolombia.reto_1.model.repositories.PersonaRepository;
import com.bancolombia.reto_1.model.services.interfaces.ILugarService;
import com.bancolombia.reto_1.model.utils.dto.request.LugarRequest;
import com.bancolombia.reto_1.model.utils.dto.response.LugarResponse;
import com.bancolombia.reto_1.model.utils.dto.response.PersonaToLugarResponse;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LugarService implements ILugarService {

    @Autowired
    private final LugarRepository lugarRepository;
    @Autowired
    private final PersonaRepository personaRepository;

    @Override
    public Page<LugarResponse> getAll(int page, int size) {
        
        if(page < 0)
        page = 0;

        PageRequest paginacion = PageRequest.of(page, size);

        return this.lugarRepository.findAll(paginacion).map(lugar -> entityToResponse(lugar));
    }

    @Override
    public List<LugarResponse> findByName(String nombre) {

        List<LugarEntity> lugar= this.lugarRepository.findByNombre(nombre);

        return lugar.stream()
            .map(this::entityToResponse)
            .collect(Collectors.toList());
    }

    @Override
    public List<LugarResponse> findByPais(String nombre) {
        
        List<LugarEntity> lugar = this.lugarRepository.findByPais(nombre);

         return lugar.stream()
            .map(this::entityToResponse)
            .collect(Collectors.toList());
    }

   

    @Override
    public LugarResponse create(LugarRequest request) {

        PersonaEntity persona = this.personaRepository.findById(request.getPersonaID()).orElseThrow();

        LugarEntity lugar = this.requestToLugar(request, new LugarEntity());
        lugar.setPersona(persona);


        return this.entityToResponse(this.lugarRepository.save(lugar));
    }

    private LugarResponse entityToResponse(LugarEntity entity) {

        LugarResponse response = new LugarResponse();

        BeanUtils.copyProperties(entity, response);

        PersonaToLugarResponse lugarDTO = new PersonaToLugarResponse();

        BeanUtils.copyProperties(entity.getPersona(), lugarDTO);

        response.setPersona(lugarDTO);

        return response;
    }

    private LugarEntity requestToLugar(LugarRequest request, LugarEntity entity) {

        entity.setNombre(request.getNombre());
        entity.setDepartamento(request.getDepartamento());
        entity.setPais(request.getPais());

        return entity;
    }






    


}
