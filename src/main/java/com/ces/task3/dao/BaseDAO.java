package com.ces.task3.dao;


import com.ces.task3.model.Page;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

public interface BaseDAO<E ,PK> {


    void create(E newEntity);
    Optional<E> getById(PK id);
    Optional<E> update(E newEntity);
    void delete(E entity);
    Collection<E> getAll();
    Collection<E> getAll(Page page);

    //method use equal (=) operator.
    Collection<E> getAllByProperty( Map<String, String> properties);
    Collection<E> getAllByProperty( Map<String, String> properties, Page p);
}
