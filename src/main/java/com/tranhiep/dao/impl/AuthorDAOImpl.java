package com.tranhiep.dao.impl;

import com.tranhiep.dao.AuthorDAO;
import com.tranhiep.dao.BasicDAO;
import com.tranhiep.dao.BookDAO;

import javax.persistence.EntityManager;

public class AuthorDAOImpl extends BasicDAO implements AuthorDAO {
    public AuthorDAOImpl(EntityManager entityManager) {
        super(entityManager);
    }
}
