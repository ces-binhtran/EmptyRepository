package com.tranhiep.dao;

import javax.persistence.EntityManager;

public class BasicDAO {

    private final EntityManager entityManager;

    public BasicDAO(EntityManager entityManager){
        this.entityManager = entityManager;
    }
}
