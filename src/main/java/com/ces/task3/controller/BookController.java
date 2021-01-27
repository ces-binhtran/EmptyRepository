package com.ces.task3.controller;


import com.ces.task3.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = {"/", "/book"})
public class BookController {

    private BookService bookService;
    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping
    private String getAllBook(){
        System.out.println("-----------------");
        return "book/book";
    }
}
