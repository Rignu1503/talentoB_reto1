package com.bancolombia.reto_1.model.services.interfaces;

import org.springframework.data.domain.Page;

public interface CrudService<RQ, RS, ID> {
    
    Page<RS> getAll(int page, int size);

    RS create(RQ request);

}
