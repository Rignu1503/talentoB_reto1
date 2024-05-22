package com.bancolombia.reto_1.model.services.interfaces;

import java.util.List;

import com.bancolombia.reto_1.model.utils.dto.request.LugarRequest;
import com.bancolombia.reto_1.model.utils.dto.response.LugarResponse;

public interface ILugarService extends CrudService<LugarRequest, LugarResponse, Long>{

    public List<LugarResponse> findByName(String name);

    public List<LugarResponse> findByPais(String nombre);
    
}

