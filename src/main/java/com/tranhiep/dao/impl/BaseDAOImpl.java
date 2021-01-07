package com.tranhiep.dao.impl;

import com.tranhiep.dao.BaseDAO;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.Collection;

public class BaseDAOImpl<E> implements BaseDAO<E> {
    private final EntityManager entityManager;
    public BaseDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public Collection<E> getAll(Class<E> type) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<E> criteriaQuery = criteriaBuilder.createQuery(type);
        criteriaQuery.from(type);
        TypedQuery<E> typedQuery = entityManager.createQuery(criteriaQuery);
        return typedQuery.getResultList();
    }

    @Override
    public E getOneById(Class<E> type,Object id) {
        return entityManager.find(type, id);
    }

    @Override
    public E create(E entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.refresh(entity);
        entityManager.getTransaction().commit();
        return entity;
    }

    @Override
    public E update( E entity) {

        entityManager.getTransaction().begin();
        E r = entityManager.merge(entity);
        entityManager.getTransaction().commit();
        return r;
    }

    @Override
    public void delete(Class<E> type,Object id) {
        E e = getOneById(type, id);

        entityManager.getTransaction().begin();
        entityManager.remove(e);
        entityManager.getTransaction().commit();
    }
}
