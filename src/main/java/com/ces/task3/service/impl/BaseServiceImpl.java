package com.ces.task3.service.impl;

import com.ces.task3.dao.BaseDAO;
import com.ces.task3.model.Page;
import com.ces.task3.service.BaseService;
import org.modelmapper.ModelMapper;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.ParameterizedType;
import java.util.*;
import java.util.stream.Collectors;


public class BaseServiceImpl<DAO extends BaseDAO ,DTO, E, PK> implements BaseService<DTO, E, PK> {

    protected DAO dao;
    protected ModelMapper modelMapper;
    private Class<DTO> dtoClass;

    public BaseServiceImpl(DAO dao, ModelMapper modelMapper){
        this.dao = dao;
        this.modelMapper = modelMapper;

        //get Class Type of DTO use Reflection API.
        this.dtoClass =  (Class<DTO>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[1];
    }


    @Override
    @Transactional
    public Optional<DTO> create(Object entity) {
        return Optional.of(modelMapper.map(dao.createEntity(entity), dtoClass));
    }

    @Override
    @Transactional
    public Optional<DTO> update(Object id, Object entity) {
        return Optional.of(modelMapper.map(dao.update(id, entity), dtoClass));
    }

    @Override
    @Transactional
    public void delete(Object id) {
        dao.delete(id);
    }

    @Override
    @Transactional
    public Optional<DTO> getById(Object id) {
        return Optional.of(modelMapper.map(dao.getById(id), dtoClass));
    }

    @Override
    @Transactional
    public Collection<DTO> getAll() {
        return _castEntityToDTO(dao.getAll());
    }

    @Override
    @Transactional
    public Collection<DTO> getAllWithPage(Page page) {
        return _castEntityToDTO(dao.getAllWithPage(page));
    }

    @Override
    @Transactional
    public Collection<DTO> getAllByPropertyWithPage(Map<String, String> properties, Page page) {
        return _castEntityToDTO(dao.getAllByPropertyWithPage(properties, page));
    }

    @Override
    @Transactional
    public Collection<DTO> getAllByProperty(Map<String, String> properties) {
        return _castEntityToDTO(dao.getAllByProperty(properties));
    }

    protected Collection<DTO> _castEntityToDTO(Collection<E> entities){
        return  entities
                .stream()
                .map(ele -> modelMapper.map(ele, dtoClass))
                .collect(Collectors.toList());
    }
}
