package com.tranhiep.controller;

import com.tranhiep.util.Utils;

import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/Book")
public class BookServlet extends HttpServlet {

    public BookServlet(){
        // create EntityManagerFactory
        Persistence.createEntityManagerFactory("book_manager");
        // c
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("WEB-INF/book.jsp").forward(req,resp);

    }
}
