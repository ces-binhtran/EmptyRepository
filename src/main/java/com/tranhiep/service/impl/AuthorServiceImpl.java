package com.tranhiep.service.impl;

import com.tranhiep.dao.AuthorDAO;
import com.tranhiep.dao.impl.AuthorDAOImpl;
import com.tranhiep.entity.AuthorEntity;
import com.tranhiep.service.AuthorService;
import com.tranhiep.util.HibernateUtils;

import javax.persistence.EntityManager;
import java.util.Collection;

public class AuthorServiceImpl implements AuthorService {

    private final EntityManager entityManager;
    private final AuthorDAO authorDAO;

    public AuthorServiceImpl(){
        entityManager = HibernateUtils.getEntityManager();
        authorDAO = new AuthorDAOImpl(entityManager);
    }


    @Override
    public Collection<AuthorEntity> getAll() {
        return authorDAO.getAll(AuthorEntity.class);
    }

    @Override
    public AuthorEntity getOneById(Integer id) {
        return authorDAO.getOneById(AuthorEntity.class, id);
    }

    @Override
    public AuthorEntity create(AuthorEntity authorEntity) {
        return authorDAO.create(authorEntity);
    }

    @Override
    public AuthorEntity update(AuthorEntity authorEntity) {
        return authorDAO.update(authorEntity);
    }

    @Override
    public void delete(Integer authorId) {
        authorDAO.delete(AuthorEntity.class, authorId);
    }
}
