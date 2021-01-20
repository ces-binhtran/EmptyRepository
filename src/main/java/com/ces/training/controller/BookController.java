package com.ces.training.controller;

import com.ces.training.dto.AuthorDTO;
import com.ces.training.dto.BookDTO;
import com.ces.training.service.BookService;
import com.ces.training.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value = "/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "")
    public ModelAndView findAll() {
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("books", bookService.findAll());
        return modelAndView;
    }

    @RequestMapping(value = "/{bookId}/delete")
    public String delete(@PathVariable Integer bookId) {
        return bookService.delete(bookId);
    }

    @RequestMapping(value = "/create")
    public String create() {
        return "bookForm";
    }
}
