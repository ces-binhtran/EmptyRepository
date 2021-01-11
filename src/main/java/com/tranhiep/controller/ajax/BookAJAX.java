package com.tranhiep.controller.ajax;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.tranhiep.entity.BookEntity;
import com.tranhiep.service.BookService;
import com.tranhiep.service.impl.BookServiceImpl;
import com.tranhiep.util.AJAXUtils;
import com.tranhiep.util.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Book_ajax/*")
public class BookAJAX extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        BookService bookService = new BookServiceImpl(Utils.getEntityManagerFromReq(req));

        // convert json object from body of req to string
        JsonObject data = new Gson().fromJson(req.getReader(), JsonObject.class);
        String name = data.get("name").getAsString();
        String type = data.get("type").getAsString();

        String stringId = req.getParameter("bookId");
        if(name.isEmpty()){
            throw new ServletException("Some thing error!");
        }

        if(stringId == null){
            // Create mode --> create new book
            BookEntity bookEntity = new BookEntity(name, type);
            AJAXUtils.sendJson(resp, bookService.create(bookEntity));

        }else {
            // Edit mode --> find and edit book
            Integer bookId = Integer.parseInt(stringId);
            BookEntity  bookEntity = bookService.getOneById(bookId);
            bookEntity.setValue(name, type);
            AJAXUtils.sendJson(resp, bookService.update(bookEntity));
        }
    }
}
