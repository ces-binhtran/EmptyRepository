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
import java.util.Optional;

public abstract class BaseDAOImpl<E,PK> implements BaseDAO<E,PK>{

    private Class<E> entityClass;

    @PersistenceContext
    protected EntityManager entityManager;

    public BaseDAOImpl(){

        //use ReflectionAPI to get Class of Entity
        ParameterizedType params = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = (Class<E>) params.getActualTypeArguments()[0];

    }

    @Override
    public void create(E newEntity) {
        entityManager.persist(newEntity);
        entityManager.refresh(newEntity);
    }

    @Override
    public Optional<E> getById(PK id) {
        return Optional.ofNullable(entityManager.find(entityClass, id));
    }

    @Override
    public Optional<E> update(E entity)  {
        return Optional.of(entityManager.merge(entity));
    }

    @Override
    public void delete(E entity) {
        entityManager.remove(entity);
    }

    @Override
    public Collection<E> getAll() {
        return _getEntityCollection(null, null);
    }

    @Override
    public Collection<E> getAll(Page page) {
        return _getEntityCollection(null, page);
    }


    @Override
    public Collection<E> getAllByProperty(Map<String, String> properties) {
        return  _getEntityCollection(properties, null);
    }

    @Override
    public Collection<E> getAllByProperty(Map<String, String> properties, Page page) {
        return _getEntityCollection(properties, page);
    }


    protected Collection<E> _getEntityCollection(Map<String, String> properties, Page page){

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<E> query = cb.createQuery(entityClass);
        Root<E> entityRoot = query.from(entityClass);

        // equal chain
        if( properties != null && !properties.isEmpty() ){
            Predicate[] conditionEquals = properties
                    .entrySet()
                    .stream()
                    .map(ele -> cb.equal(entityRoot.get(ele.getKey()), ele.getValue()))
                    .toArray(Predicate[]::new);
            query.where(conditionEquals);
        }
        Query result = entityManager.createQuery(query);

        // pagination
        if(page != null){
            result.setFirstResult((page.getPageNumber() - 1)* page.getPageSize());
            result.setMaxResults(page.getPageSize());
        }
        return result.getResultList();
    }
}
