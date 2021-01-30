package com.ces.task3.controller;


import com.ces.task3.dto.BookDTO;
import com.ces.task3.dto.TypeDTO;
import com.ces.task3.model.exception.InternalException;
import com.ces.task3.model.exception.NotFoundException;
import com.ces.task3.service.BookService;
import com.ces.task3.service.TypeService;
import com.ces.task3.util.Utils;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = {"/", "/book"})
public class BookController {

    private BookService bookService;
    private TypeService typeService;
    private ModelMapper modelMapper;


    public BookController(
            BookService bookService,
            TypeService typeService,
            ModelMapper modelMapper
    ){
        this.bookService = bookService;
        this.typeService = typeService;
        this.modelMapper = modelMapper;
    }

    //handler convert author name.
    @GetMapping("/converter")
    private String convertListAuthor(HttpServletRequest request){
        List<BookDTO> books = (List<BookDTO>) request.getAttribute("books");

        //convert list author of each book to String ( a - b... )
        List<String> authorsOfBooks = books.stream()
                .map(book -> Utils.authorsToString(book.getAuthors(), 2))
                .collect(Collectors.toList());
        request.setAttribute("authorsOfBooks", authorsOfBooks);
        return "book/book";
    }

    @GetMapping
    private String getAllBook(Model model) throws InternalException {
        model.addAttribute("books", bookService.getAll());
        return "forward:book/converter";
    }

    @GetMapping("/type")
    public String getBookByType(@RequestParam("type") Optional<Integer> typeIdOpt, Model model) throws NotFoundException {
        if(typeIdOpt.isPresent()){
            model.addAttribute("books", bookService.getAllBookByTypeId(typeIdOpt.get()));
            return "forward:/book/converter";
        }
        return "redirect:/";
    }

    @GetMapping("/search")
    public String getBookBySearch(@RequestParam("query") Optional<String> query, Model model) throws NotFoundException {
        if(query.isPresent()){
            model.addAttribute("books", bookService.getAllBookByName(query.get()));
            return "forward:/book/converter";
        }
        return "redirect:/";
    }

    @GetMapping("/create")
    private String create(@ModelAttribute("book")BookDTO bookDTO, Model model){
        model.addAttribute("createMode", true);
        return "book/create_edit";
   }

    @GetMapping("/edit/{bookId}")
    private String edit(@ModelAttribute("book")BookDTO bookDTO, @PathVariable Integer bookId, Model model) throws NotFoundException {
        bookDTO.copyValue(bookService.getById(bookId));
        model.addAttribute("createMode", false);
        return "book/create_edit";
    }


    @ModelAttribute(name = "types")
    private Collection<TypeDTO> getAllType(){
        return typeService.getAll();
   }


}
