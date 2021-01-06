package com.tranhiep.dao.impl;

import com.tranhiep.dao.BasicDAO;
import com.tranhiep.dao.BookDAO;

import javax.persistence.EntityManager;

public class BookDAOImpl extends BasicDAO implements BookDAO {


    public BookDAOImpl(EntityManager entityManager) {
        super(entityManager);
    }
}
