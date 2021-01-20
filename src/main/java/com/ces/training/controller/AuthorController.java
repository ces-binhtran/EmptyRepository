package com.ces.training.controller;

import com.ces.training.dto.AuthorDTO;
import com.ces.training.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @RequestMapping(value = "/create")
    public String create() {
        return "authorForm";
    }

    @RequestMapping(value = "/save")
    public String save(@ModelAttribute("author") AuthorDTO authorDTO) {
        authorService.save(authorDTO);
        return "bookForm";
    }
}
