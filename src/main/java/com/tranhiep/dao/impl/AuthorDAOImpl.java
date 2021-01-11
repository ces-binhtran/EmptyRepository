package com.tranhiep.dao.impl;


import com.tranhiep.dao.AuthorDAO;
import com.tranhiep.entity.AuthorEntity;
import com.tranhiep.entity.BookEntity;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import java.util.Collection;

public class AuthorDAOImpl extends BaseDAOImpl<AuthorEntity> implements AuthorDAO {

    private final EntityManager entityManager;
    public AuthorDAOImpl(EntityManager entityManager) {
        super(entityManager);
        this.entityManager = entityManager;
    }

    @Override
    public Collection<AuthorEntity> getAllByBookId(Integer bookId) {
        entityManager.getTransaction().begin();
        TypedQuery<AuthorEntity> query = entityManager.createNamedQuery("author.getAllAuthorOfBookId", AuthorEntity.class);
        query.setParameter("bookId", bookId);
        entityManager.getTransaction().commit();
        return query.getResultList();
    }

    @Override
    public AuthorEntity addAuthorToBook(Integer authorId, Integer bookId) {
        entityManager.getTransaction().begin();
        AuthorEntity authorEntity = entityManager.find(AuthorEntity.class, authorId);
        BookEntity bookEntity= entityManager.find(BookEntity.class, bookId);

        bookEntity.getAuthors().add(authorEntity);
        entityManager.flush();
        entityManager.getTransaction().commit();

        return authorEntity;
    }

    @Override
    public void deleteAuthorFromBook(Integer authorId, Integer bookId) {
        entityManager.getTransaction().begin();
        AuthorEntity authorEntity = entityManager.find(AuthorEntity.class, authorId);
        BookEntity bookEntity= entityManager.find(BookEntity.class, bookId);

        bookEntity.getAuthors().remove(authorEntity);
        entityManager.flush();
        entityManager.getTransaction().commit();
    }
}
