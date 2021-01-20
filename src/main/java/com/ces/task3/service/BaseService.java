package com.ces.task3.service;

import com.ces.task3.model.Page;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;


public interface BaseService<DTO, E, PK>{
    Optional<DTO> create(E entity);
    Optional<DTO> update(PK id, E entity);
    void delete(PK id);
    Optional<DTO> getById(PK id);
    Collection<DTO> getAll();
    Collection<DTO> getAllWithPage(Page page);
    Collection<DTO> getAllByProperty(Map<String ,String> properties);
    Collection<DTO> getAllByPropertyWithPage(Map<String ,String> properties, Page page);
}