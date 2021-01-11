package com.tranhiep.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtils {

    private static EntityManagerFactory entityManagerFactory;


    public static EntityManager getEntityManager(){
        if(entityManagerFactory == null){
            entityManagerFactory = Persistence.createEntityManagerFactory("book_manager");
        }
        return entityManagerFactory.createEntityManager();
    }
}
