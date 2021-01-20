package com.ces.task3.dao;


import com.ces.task3.model.Page;

import java.util.Collection;
import java.util.Map;

public interface BaseDAO<E ,PK> {

    E createEntity(E newEntity);
    E getById(PK id);
    E update(PK id, E newEntity);
    void delete(PK id);
    Collection<E> getAll();
    Collection<E> getAllWithPage(Page page);

    //method use equal (=) operator.
    Collection<E> getAllByProperty( Map<String, String> properties);
    Collection<E> getAllByPropertyWithPage(Map<String, String> properties, Page p);
}
