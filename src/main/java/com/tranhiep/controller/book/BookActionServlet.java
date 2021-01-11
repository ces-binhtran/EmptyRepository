package com.tranhiep.controller.book;


import com.tranhiep.entity.BookEntity;
import com.tranhiep.service.AuthorService;
import com.tranhiep.service.BookService;
import com.tranhiep.service.impl.AuthorServiceImpl;
import com.tranhiep.service.impl.BookServiceImpl;
import com.tranhiep.util.Utils;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/book_action")
public class BookActionServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        EntityManager entityManager = Utils.getEntityManagerFromReq(req);
        AuthorService authorService = new AuthorServiceImpl(entityManager);
        BookService bookService = new BookServiceImpl(entityManager);

        String stringId = req.getParameter("bookId");
        req.setAttribute("authors", authorService.getAll());
        if(stringId != null){
            // Edit mode ---> find book with param bookName
            int id = Integer.parseInt(stringId);
            req.setAttribute("book", bookService.getOneById(id));
        }
        req.getRequestDispatcher("WEB-INF/book/create_edit.jsp")
                .forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
//        EntityManager entityManager = Utils.getEntityManagerFromReq(req);
//        bookService = new BookServiceImpl(entityManager);
//
//        String name = req.getParameter("name");
//        String type = req.getParameter("type");
//
//        String stringId = req.getParameter("id");
//        if(name.isEmpty()){
//            throw new ServletException("Some thing error!");
//        }
//
//        if(stringId == null){
//            // Create mode --> create new book
//            BookEntity bookEntity = new BookEntity(name, type);
//            bookService.create(bookEntity);
//
//        }else {
//            // Edit mode --> find and edit book
//            Integer bookId = Integer.parseInt(stringId);
//            BookEntity  bookEntity = bookService.getOneById(bookId);
//            bookEntity.setValue(name, type);
//            bookService.update(bookEntity);
//
//        }
//        resp.sendRedirect("Book");

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        BookService bookService = new BookServiceImpl(Utils.getEntityManagerFromReq(req));
        int id =Integer.parseInt(req.getParameter("id"));
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        //find element
        BookEntity book = bookService.getOneById(id);
        if(book == null){
            //not found element
        }else{
            // founded element
            bookService.delete(book.getId());
            resp.getWriter().write("{\"status\":" + "\"success\"}");
        }
    }
}
