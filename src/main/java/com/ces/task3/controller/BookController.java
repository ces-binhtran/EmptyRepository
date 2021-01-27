package com.ces.task3.controller;


import com.ces.task3.dto.BookDTO;
import com.ces.task3.dto.TypeDTO;
import com.ces.task3.entity.BookEntity;
import com.ces.task3.model.exception.BadRequestException;
import com.ces.task3.model.exception.InternalException;
import com.ces.task3.service.BookService;
import com.ces.task3.service.TypeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Collection;

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

    @GetMapping
    private String getAllBook() throws InternalException {
        return "book/book";
    }

    @PostMapping
    private String handlerCreate(@Valid @ModelAttribute("book")BookDTO newBook, BindingResult result) throws InternalException, BadRequestException {
        if(result.hasErrors()){
            return "book/create_edit";
        }
        if(newBook.getName().isEmpty() || newBook.getType() == null){
            throw BadRequestException.builder("Name", "Type");
        }
        bookService.create(modelMapper.map(newBook, BookEntity.class));
        return "redirect:book";
    }


    @GetMapping
    @RequestMapping("/create")
   private String create(@ModelAttribute("book")BookDTO bookDTO){
        return "book/create_edit";
   }

   @ModelAttribute(name = "types")
   private Collection<TypeDTO> getAllType(){
        return typeService.getAll();
   }


}
