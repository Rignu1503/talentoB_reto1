package com.bancolombia.reto_1.services.interfaces;

import org.springframework.data.domain.Page;

public interface CrudService<RQ, RS, ID> {
    
    Page<RS> getAll(int page, int size);

    RS create(RQ request);

}
