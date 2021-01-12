package controller;

import entity.AuthorEntity;
import service.AuthorService;
import service.BookService;
import service.impl.AuthorServiceImpl;
import service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/Book")
public class BookServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String type = request.getParameter("type");
        switch(type) {
            case "create-form": {
                AuthorService authorService = new AuthorServiceImpl();
                request.setAttribute("authors", authorService.getAll());
                request.getRequestDispatcher("/views/addBook.jsp").forward(request, response);
            }
            case "create": {
                String name = request.getParameter("name");
                Object[] authors = request.getParameterValues("author");
                System.out.println(name + authors[0].getClass().getName());
            }
            default: {
                doGet(request, response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BookService bookService = new BookServiceImpl();
        request.setAttribute("books", bookService.getAllBook());
        System.out.println(2);
        request.getRequestDispatcher("/views/listBook.jsp").forward(request,response);

        response.getWriter();

    }
}
