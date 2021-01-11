package com.tranhiep.util;

import javax.persistence.EntityManager;
import javax.servlet.ServletRequest;

public class Utils {

    public static String rootPath = "http://localhost:8080/EmptyRepository_war/";

    public static EntityManager getEntityManagerFromReq(ServletRequest req){
        return (EntityManager) req.getAttribute("entityManager");
    }
}
