package com.tranhiep.dao.impl;


import com.tranhiep.dao.AuthorDAO;
import com.tranhiep.entity.AuthorEntity;

import javax.persistence.EntityManager;

public class AuthorDAOImpl extends BaseDAOImpl<AuthorEntity> implements AuthorDAO {

    public AuthorDAOImpl(EntityManager entityManager) {
        super(entityManager);
    }
}
