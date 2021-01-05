package com.tranhiep;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;


@WebServlet("/book_action")
public class BookActionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String stringId = req.getParameter("id");

        if(stringId == null){
            // Create mode
        }else{
            // Edit mode ---> find book with param bookName
            int id = Integer.parseInt(stringId);
            Book book = Util.findBookById(id);
            req.setAttribute("book", book);

        }
        req.getRequestDispatcher("WEB-INF/create_edit.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String author = req.getParameter("author");
        String stringId = req.getParameter("id");
        if(name.isEmpty()){
            new Exception("Some thing error!");
        }

        if(stringId == null){
            // Create mode --> create new book
            Random  random = new Random();
            Book book = new Book(10+random.nextInt(1000),name, author);
            Util.books.add(book);

        }else {
            // Edit mode --> find and edit book
            Book book = Util.findBookById(Integer.parseInt(stringId));
            book.setName(name);
            book.setAuthor(author);
        }
        resp.sendRedirect("Book");

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id =Integer.parseInt(req.getParameter("id"));
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        //find element
        Book book = Util.findBookById(id);
        if(book == null){
            //not found element
        }else{
            // founded element
            Util.books.remove(book);
            resp.getWriter().write("{\"status\":" + "\"success\"}");
        }
    }
}
