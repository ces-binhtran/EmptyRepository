package com.tranhiep.controller;

import com.tranhiep.dao.BookDAO;
import com.tranhiep.dao.impl.BookDAOImpl;
import com.tranhiep.entity.AuthorEntity;
import com.tranhiep.entity.BookEntity;
import com.tranhiep.service.BookService;
import com.tranhiep.service.impl.BookServiceImpl;
import com.tranhiep.util.HibernateUtils;
import org.hibernate.Transaction;


import javax.persistence.EntityManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;


@WebServlet("/Book")
public class BookServlet extends HttpServlet {

    private final BookService bookService;
    public BookServlet(){
        bookService = new BookServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Collection<BookEntity> books = bookService.getAll();
        req.setAttribute("books", books);
        req.getRequestDispatcher("WEB-INF/book.jsp").forward(req,resp);

    }
}
