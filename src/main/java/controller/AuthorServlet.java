package controller;

import service.AuthorService;
import service.impl.AuthorServiceImpl;
import utils.ResponseMessage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/Author")
public class AuthorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        if(name == "") {
            request.setAttribute("error", "Author's name can't empty.");
            request.getRequestDispatcher("/views/addAuthor.jsp").forward(request, response);
        } else {
            AuthorService authorService = new AuthorServiceImpl();
            authorService.addAuthor(name);
            request.setAttribute("authors", authorService.getAll());
            doGet(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/views/addBook.jsp").forward(request, response);
    }
}
