package com.tranhiep.dao;

import java.util.Collection;

public interface BaseDAO<E>{

    public Collection<E> getAll(Class<E> type);
    public E getOneById(Class<E> type,Object id);
    public E create(E entity);
    public E update(E entity);
    public void delete(Class<E> type, Object id);

}
