package com.ces.training.controller;

import com.ces.training.dto.BookDTO;
import com.ces.training.service.AuthorService;
import com.ces.training.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
@RequestMapping(value = "/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, "publish", new CustomDateEditor(new SimpleDateFormat("yyy-MM-dd"), true));
        binder.registerCustomEditor(Integer.class, "price", new CustomNumberEditor(Integer.class, true ));
    }

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
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("bookForm");
        modelAndView.addObject("authors", authorService.findAll());
        return modelAndView;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(@Valid @ModelAttribute("book") BookDTO bookDTO,
                             BindingResult result,
                             Model model,
                             @RequestParam("author") String[] ids) {
        ModelAndView modelAndView = new ModelAndView();
        if(result.hasErrors()) {
            modelAndView.setViewName("bookForm");
            modelAndView.addObject("authors", authorService.findAll());
            return modelAndView;
        }
        bookService.save(bookDTO, ids);
        modelAndView.setViewName("home");
        modelAndView.addObject("books", bookService.findAll());
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{bookId}")
    public ModelAndView edit(@Valid @ModelAttribute("book") BookDTO bookDTO, BindingResult result, @PathVariable Integer bookId) {
        ModelAndView modelAndView = new ModelAndView();
        if(result.hasErrors()) {
            modelAndView.setViewName("bookForm");
            modelAndView.addObject("authors", authorService.findAll());
            return modelAndView;
        }
        modelAndView.addObject("book", bookService.get(bookId));
        modelAndView.addObject("authors", authorService.findAll());
        return modelAndView;
    }

    @RequestMapping(value = "/update")
    public ModelAndView update() {
        return null;
    }
}
