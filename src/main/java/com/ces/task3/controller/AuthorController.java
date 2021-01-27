package com.ces.task3.controller;

import com.ces.task3.dto.AuthorDTO;
import com.ces.task3.entity.AuthorEntity;
import com.ces.task3.model.exception.BadRequestException;
import com.ces.task3.service.AuthorService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/author")
public class AuthorController {

    private AuthorService authorService;
    private ModelMapper modelMapper;

    public AuthorController(
            AuthorService authorService,
            ModelMapper modelMapper
    ){
        this.authorService = authorService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    @RequestMapping("/create")
    private String create(@ModelAttribute("author")AuthorDTO authorDTO){
        return "author/create_edit";
    }

    @PostMapping
    private String handlerCreate(AuthorDTO newAuthor) throws BadRequestException {
        if(newAuthor.getName().isEmpty()){
            throw BadRequestException.builder("Name");
        }
        authorService.create(modelMapper.map(newAuthor, AuthorEntity.class));
        return "redirect:book";
    }
}
