package com.bancolombia.reto_1.model.services;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.bancolombia.reto_1.entities.LugarEntity;
import com.bancolombia.reto_1.entities.PersonaEntity;
import com.bancolombia.reto_1.model.repositories.PersonaRepository;
import com.bancolombia.reto_1.model.services.interfaces.IPersonaService;
import com.bancolombia.reto_1.model.utils.dto.request.PersonaRequest;
import com.bancolombia.reto_1.model.utils.dto.response.LugarToPersonaResponse;
import com.bancolombia.reto_1.model.utils.dto.response.PersonaResponse;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PersonaService implements IPersonaService {

    @Autowired
    private final PersonaRepository personaRepository;

    @Override
    public Page<PersonaResponse> getAll(int page, int size) {

         if(page < 0)
        page = 0;

        PageRequest paginacion = PageRequest.of(page, size);

        return this.personaRepository.findAll(paginacion).map(persona -> entityToResponse(persona));
    }

    private PersonaEntity find(Long id){
        return personaRepository.findById(id).orElse(null);
    }

    @Override
    public PersonaResponse create(PersonaRequest request) {

        PersonaEntity persona = this.requestToentity(request, new PersonaEntity());

        return this.entityToResponse(this.personaRepository.save(persona));
    }

    private PersonaResponse entityToResponse(PersonaEntity persona) {

        PersonaResponse response = new PersonaResponse();
        BeanUtils.copyProperties(persona, response);
    
        response.setLugar(
                persona.getLugar().stream()
                .map(this::lugarToResponse)
                .collect(Collectors.toList()));
    
        return response;
    }
    
    private LugarToPersonaResponse lugarToResponse(LugarEntity entity) {

        LugarToPersonaResponse response = new LugarToPersonaResponse();
        BeanUtils.copyProperties(entity, response);

        return response;
    }
    
    private PersonaEntity requestToentity(PersonaRequest request, PersonaEntity entity) {

        entity.setNombre(request.getNombre());
        entity.setEdad(request.getEdad());
        entity.setOcupacion(request.getOcupacion());
        if(entity.getLugar() == null) {
            entity.setLugar(new ArrayList<>());
        }

        return entity;

    }

}
