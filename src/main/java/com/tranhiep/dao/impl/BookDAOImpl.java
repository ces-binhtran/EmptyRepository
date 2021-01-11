package com.tranhiep.dao.impl;

import com.tranhiep.dao.BookDAO;
import com.tranhiep.entity.BookEntity;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Collection;


public class BookDAOImpl extends BaseDAOImpl<BookEntity> implements BookDAO{

    private final EntityManager entityManager;

    public BookDAOImpl(EntityManager entityManager) {
        super(entityManager);
        this.entityManager = entityManager;
    }

    @Override
    public Collection<BookEntity> getAllByAuthorId(Integer authorId) {
        entityManager.getTransaction().begin();
        TypedQuery<BookEntity> query = entityManager.createNamedQuery("book.getAllByAuthorId", BookEntity.class);
        query.setParameter("authorId", authorId);
        entityManager.getTransaction().commit();
        return query.getResultList();
    }
}
