package com.tranhiep.dao.impl;

import com.tranhiep.dao.BookDAO;
import com.tranhiep.entity.BookEntity;

import javax.persistence.EntityManager;
import java.util.Collection;

public class BookDAOImpl extends BaseDAOImpl<BookEntity> implements BookDAO{


    public BookDAOImpl(EntityManager entityManager) {
        super(entityManager);
    }
}
