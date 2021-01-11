package com.tranhiep.controller.author;

import com.tranhiep.entity.AuthorEntity;
import com.tranhiep.service.AuthorService;
import com.tranhiep.service.impl.AuthorServiceImpl;
import com.tranhiep.util.Utils;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/Author")
public class AuthorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        EntityManager entityManager = Utils.getEntityManagerFromReq(req);
        AuthorService authorService = new AuthorServiceImpl(entityManager);
        List<AuthorEntity> authorEntities = (List<AuthorEntity>) authorService.getAll();
        req.setAttribute("authors", authorEntities);
        authorEntities.forEach(e-> e.getBooks().size());

        req.getRequestDispatcher("WEB-INF/author/author.jsp").forward(req,resp);

    }
}
