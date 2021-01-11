package com.tranhiep.listener;

import com.tranhiep.util.HibernateUtils;

import javax.persistence.EntityManager;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

@WebListener
public class RequestEventListener implements ServletRequestListener {

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        HttpServletRequest req = (HttpServletRequest) sre.getServletRequest();

        String reqURI = req.getRequestURI();

        // filter some static request
        if(!reqURI.endsWith(".js") && !reqURI.endsWith(".css") && !reqURI.endsWith(".png")){
            EntityManager entityManager = HibernateUtils.getEntityManager();
            req.setAttribute("entityManager", entityManager);
        }

    }


    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        ServletRequest req = sre.getServletRequest();
        EntityManager entityManager = (EntityManager) req.getAttribute("entityManager");

        //close EntityManager
        if(entityManager != null){
            entityManager.close();
        }
    }
}
