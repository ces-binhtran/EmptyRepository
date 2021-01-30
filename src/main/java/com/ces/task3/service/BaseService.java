package com.ces.task3.service;

import com.ces.task3.model.Page;
import com.ces.task3.model.exception.NotFoundException;

import java.util.Collection;
import java.util.Map;


public interface BaseService<DTO, E, PK>{
    DTO create(E entity) throws NotFoundException;
    DTO update(PK id, E entity) throws Throwable;
    void delete(PK id) throws NotFoundException;
    DTO getById(PK id) throws NotFoundException;
    Collection<DTO> getAll();
    Collection<DTO> getAll(Page page);
    Collection<DTO> getAllByProperty(Map<String ,String> properties);
    Collection<DTO> getAllByProperty(Map<String ,String> properties, Page page);
}