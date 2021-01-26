package com.ces.training.controller;

import com.ces.training.dto.AuthorDTO;
import com.ces.training.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping(value = "/author")
public class AuthorController {

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, "birth", new CustomDateEditor(new SimpleDateFormat("yyy-MM-dd"), true));
    }

    @Autowired
    private AuthorService authorService;

    @RequestMapping(value = "/create")
    public String create() {
        return "authorForm";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@Valid @ModelAttribute("author") AuthorDTO authorDTO, BindingResult result, Model model) {
        if(result.hasErrors()) {
            return "authorForm";
        }
        authorService.save(authorDTO);
        return "bookForm";
    }
}
