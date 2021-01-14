package controller;

import entity.AuthorEntity;
import entity.BookEntity;
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
        BookService bookService = new BookServiceImpl();
        AuthorService authorService = new AuthorServiceImpl();
        String type = request.getParameter("type");
        switch(type) {
            case "create-form": {
                request.setAttribute("authors", authorService.getAll());
                request.getRequestDispatcher("/views/addBook.jsp").forward(request, response);
                break;
            }
            case "create": {
                String name = request.getParameter("name");
                System.out.println("+++++++++" + name + "++++++++++");
                if(name == "") {
                    request.setAttribute("authors", authorService.getAll());
                    request.setAttribute("error", "Book's name can't empty.");
                    request.getRequestDispatcher("/views/addBook.jsp").forward(request, response);
                } else {
                    String[] authors = request.getParameterValues("author");
                    bookService.save(name, authors);
                    doGet(request, response);
                }

                break;
            }
            case "Delete": {
                Integer id = Integer.parseInt(request.getParameter("id"));
                bookService.delete(id);
                doGet(request, response);
                break;
            }
            case "Edit": {
                Integer id = Integer.parseInt(request.getParameter("id"));
                request.setAttribute("book", bookService.findById(id));
                request.setAttribute("authors", authorService.getAll());
                request.getRequestDispatcher("/views/addBook.jsp").forward(request,response);
                break;
            }
            case "update": {
                Integer id = Integer.parseInt(request.getParameter("id"));
                String name = request.getParameter("name");
                String[] authors = request.getParameterValues("author");
                bookService.update(id, name, authors);
                doGet(request, response);
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
        request.getRequestDispatcher("/views/listBook.jsp").forward(request,response);
    }
}
