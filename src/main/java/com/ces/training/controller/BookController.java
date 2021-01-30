package com.ces.training.controller;

import com.ces.training.dto.BookDTO;
import com.ces.training.service.AuthorService;
import com.ces.training.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.lang.Nullable;
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

    @RequestMapping(value = "/delete/{bookId}", method = RequestMethod.POST)
    public ModelAndView delete(@PathVariable Integer bookId) {
        ModelAndView modelAndView = new ModelAndView("home");
        bookService.delete(bookId);
        modelAndView.addObject("books", bookService.findAll());
        return modelAndView;
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
                             @Nullable @RequestParam("author") Integer[] ids) {
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

    @RequestMapping(value = "/updateForm/{bookId}")
    public ModelAndView edit(@Valid @ModelAttribute("book") BookDTO bookDTO, BindingResult result, @PathVariable Integer bookId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("bookForm");
        modelAndView.addObject("book", bookService.get(bookId));
        modelAndView.addObject("authors", authorService.findAll());
        return modelAndView;
    }

    @RequestMapping(value = "/update/{bookId}", method = RequestMethod.POST)
    public ModelAndView update(@Valid @ModelAttribute("book") BookDTO bookDTO,
                               BindingResult result,
                               @PathVariable Integer bookId,
                               @Nullable @RequestParam("author") Integer[] authorIds) {
        ModelAndView modelAndView = new ModelAndView();
        if(result.hasErrors()) {
            modelAndView.setViewName("bookForm");
            modelAndView.addObject("book", bookService.get(bookId));
            modelAndView.addObject("authors", authorService.findAll());
            return modelAndView;
        } else {
            bookDTO.setId(bookId);
            bookService.update(bookDTO, authorIds);
            modelAndView.setViewName("home");
            modelAndView.addObject("books", bookService.findAll());
            return modelAndView;
        }
    }

    @RequestMapping(value = "/search")
    public ModelAndView search(@RequestParam("search") String name) {
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("books", bookService.findByName(name));
        return modelAndView;
    }
}
