package com.ces.controller;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ces.model.BookModel;
import com.ces.service.BookService;
import com.ces.service.impl.BookServiceImpl;

@WebServlet( value= {"/Book", "/"})
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookService bookService = new BookServiceImpl();
		request.setAttribute("books", bookService.findAllBooks());
		request.getRequestDispatcher("/views/jsp/books.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookService bookService = new BookServiceImpl();
		String name = request.getParameter("name");
		String author = request.getParameter("author");
		String type = request.getParameter("type");
		Integer id = Integer.parseInt(request.getParameter("id"));
		switch (type) {
			case "editForm": {
				request.setAttribute("book", bookService.findById(id));
				request.getRequestDispatcher("/views/jsp/add.jsp").forward(request, response);
				break;
			}
			case "delete": {
				bookService.delete(id);
				doGet(request, response);
				break;
			}
			case "edit": {
				if(name == "") {
					request.setAttribute("error", "This field can't empty.");
					request.getRequestDispatcher("/views/jsp/add.jsp").forward(request, response);
					break;
				} else {
					bookService.add(new BookModel(id, name, author));
					doGet(request, response);
					break;
				}
			}
			default: {
				doGet(request, response);
				break;
			}
		}
	}
}
