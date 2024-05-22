package com.bancolombia.reto_1.services.interfaces;

import java.util.List;

import com.bancolombia.reto_1.utils.dto.request.LugarRequest;
import com.bancolombia.reto_1.utils.dto.response.LugarResponse;

public interface ILugarService extends CrudService<LugarRequest, LugarResponse, Long>{

    public List<LugarResponse> findByName(String name);

    public List<LugarResponse> findByPais(String nombre);
    
}

