package com.tranhiep.controller.ajax;

import com.tranhiep.response.ResponseMessage;
import com.tranhiep.service.AuthorService;
import com.tranhiep.service.impl.AuthorServiceImpl;
import com.tranhiep.util.AJAXUtils;
import com.tranhiep.util.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Author_ajax/*")
public class AuthorAJAX extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String pathInfo = req.getPathInfo();
        AuthorService authorService = new AuthorServiceImpl(Utils.getEntityManagerFromReq(req));
        Object result = null;
        switch (pathInfo){
            case "/all_author":
                result = authorService.getAll();
                break;
            case "/authors_of_book":
                Integer bookId = Integer.parseInt(req.getParameter("bookId"));
                result = authorService.getAllAuthorOfBook(bookId);
                break;
            default:
                result = new ResponseMessage("Server not Responding!");
                break;
        }

        AJAXUtils.sendJson(resp, result);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        AuthorService authorService = new AuthorServiceImpl(Utils.getEntityManagerFromReq(req));

        Object result = null;
        String stringAuthorId = req.getParameter("authorId");
        String stringBookId = req.getParameter("bookId");
        if(stringAuthorId == null || stringBookId == null){
            throw new ServletException("Miss some require field!");
        }
        Integer authorId = Integer.parseInt(stringAuthorId);
        Integer bookId = Integer.parseInt(stringBookId);
        switch (pathInfo){
            case "/add_author_to_book":
                result = authorService.addAuthorToBook(authorId, bookId);
                break;
            case "/delete_author_from_book":
                authorService.deleteAuthorFromBook(authorId, bookId);
                result = new ResponseMessage("Delete success");
                break;
            default:
                result = new ResponseMessage("Server not Responding!");
                break;
        }

        AJAXUtils.sendJson(resp, result);
    }
}
