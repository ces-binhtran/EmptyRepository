package com.ces.task3.dao.impl;

import com.ces.task3.dao.BaseDAO;
import com.ces.task3.model.Page;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.Map;

public class BaseDAOImpl<E,PK> implements BaseDAO<E,PK>{

    private Class<E> entityClass;

    @PersistenceContext
    protected EntityManager entityManager;

    public BaseDAOImpl(){

        //use ReflectionAPI to get Class of Entity
        ParameterizedType params = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = (Class<E>) params.getActualTypeArguments()[0];

    }

    @Override
    public E createEntity(E newEntity) {
        entityManager.persist(newEntity);
        entityManager.refresh(newEntity);
        return newEntity;
    }

    @Override
    public E getById(PK id) {
        E entity = entityManager.find(entityClass, id);
        return entity;
    }

    @Override
    public E update(PK id, E newEntity) {

        entityManager.merge(newEntity);
        return newEntity;
    }

    @Override
    public void delete(PK id) {
        E entity = getById(id);
        entityManager.remove(entity);
    }

    @Override
    public Collection<E> getAll() {

        return _getCollectionEntity(null, null);
    }

    @Override
    public Collection<E> getAllWithPage(Page page) {
        return _getCollectionEntity(null, page);
    }


    @Override
    public Collection<E> getAllByProperty(Map<String, String> properties) {
        return  _getCollectionEntity(properties, null);
    }

    @Override
    public Collection<E> getAllByPropertyWithPage(Map<String, String> properties, Page page) {
        return _getCollectionEntity(properties, page);
    }


    protected Collection<E> _getCollectionEntity(Map<String, String> properties, Page page){

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<E> query = cb.createQuery(entityClass);
        Root<E> entityRoot = query.from(entityClass);
        if(!properties.isEmpty() || properties == null){
            Predicate[] conditionEquals = properties
                    .entrySet()
                    .stream()
                    .map(ele -> cb.equal(entityRoot.get(ele.getKey()), ele.getValue()))
                    .toArray(Predicate[]::new);
            query.where(conditionEquals);
        }
        Query result = entityManager.createQuery(query);
        if(page != null){
            result.setFirstResult((page.getPageNumber() - 1)* page.getPageSize());
            result.setMaxResults(page.getPageSize());
        }
        return result.getResultList();
    }
}
