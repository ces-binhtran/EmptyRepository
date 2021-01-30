package com.ces.task3.service.impl;

import com.ces.task3.dao.BaseDAO;
import com.ces.task3.model.Page;
import com.ces.task3.model.exception.NotFoundException;
import com.ces.task3.service.BaseService;
import org.modelmapper.ModelMapper;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Transactional
public abstract class BaseServiceImpl<DAO extends BaseDAO<E, PK> ,DTO, E, PK> implements BaseService<DTO, E, PK> {

    protected DAO dao;
    protected ModelMapper modelMapper;
    private Class<DTO> dtoClass;
    private Class<E> entityClass;
    protected final Function<E, DTO> toDTOFunc = e -> modelMapper.map(e, dtoClass);


    public BaseServiceImpl(DAO dao, ModelMapper modelMapper){
        this.dao = dao;
        this.modelMapper = modelMapper;

        //get Class Type of DTO use Reflection API.
        this.dtoClass =  (Class<DTO>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[1];
    }


    @Override
    public DTO create( E entity) throws NotFoundException {
        dao.create(entity);
        return modelMapper.map(entity, dtoClass);
    }

    @Override
    public DTO update(PK id,E entity) throws NotFoundException {
        dao.getById(id)
                .orElseThrow(() -> new NotFoundException("Id", id.toString()));
        return dao.update(entity).map(toDTOFunc).get();
    }

    @Override
    public void delete(PK id) throws NotFoundException {
        E entity = dao.getById(id)
                .orElseThrow(() -> new NotFoundException("Id", id.toString()));
        dao.delete(entity);
    }

    @Override
    public DTO getById(PK id) throws NotFoundException {
        return dao.getById(id)
                .map(toDTOFunc)
                .orElseThrow(() -> new NotFoundException("Id", id.toString()));
    }

    @Override
    public Collection<DTO> getAll() {
        return _castEntitiesToDTOs(dao.getAll());
    }

    @Override
    public Collection<DTO> getAll(Page page) {
        return _castEntitiesToDTOs(dao.getAll(page));
    }

    @Override
    public Collection<DTO> getAllByProperty(Map<String, String> properties, Page page) {
        return _castEntitiesToDTOs(dao.getAllByProperty(properties, page));
    }

    @Override
    public Collection<DTO> getAllByProperty(Map<String, String> properties) {
        return _castEntitiesToDTOs(dao.getAllByProperty(properties));
    }

    protected Collection<DTO> _castEntitiesToDTOs(Collection<E> entities){
        return entities.stream()
                .map(toDTOFunc)
                .collect(Collectors.toList());
    }

}
