package com.tranhiep.controller.author;

import com.tranhiep.entity.AuthorEntity;
import com.tranhiep.service.AuthorService;
import com.tranhiep.service.impl.AuthorServiceImpl;
import com.tranhiep.util.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/author_action")
public class AuthorActionServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AuthorService authorService = new AuthorServiceImpl(Utils.getEntityManagerFromReq(req));
        String stringAuthorId = req.getParameter("authorId");

        if(stringAuthorId != null){
            // edit mode -> get author by id
            Integer authorId = Integer.parseInt(stringAuthorId);
            AuthorEntity authorEntity = authorService.getOneById(authorId);
            req.setAttribute("author", authorEntity);

        }

        req.getRequestDispatcher("WEB-INF/author/create_author.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AuthorService authorService = new AuthorServiceImpl(Utils.getEntityManagerFromReq(req));

        String name = req.getParameter("name");

        AuthorEntity authorEntity = new AuthorEntity();
        authorEntity.setName(name);
        authorService.create(authorEntity);

        resp.sendRedirect("Author");

    }
}
