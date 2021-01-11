package com.tranhiep.controller.book;

import com.tranhiep.entity.BookEntity;
import com.tranhiep.service.BookService;
import com.tranhiep.service.impl.BookServiceImpl;
import com.tranhiep.util.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;


@WebServlet("/Book")
public class BookServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        BookService bookService = new BookServiceImpl(Utils.getEntityManagerFromReq(req));
        Collection<BookEntity> books = bookService.getAll();
        req.setAttribute("books", books);
        req.getRequestDispatcher("WEB-INF/book/book.jsp").forward(req,resp);
    }
}
