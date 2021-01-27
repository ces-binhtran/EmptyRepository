package com.ces.task3.api;

import com.ces.task3.dto.AuthorDTO;
import com.ces.task3.service.AuthorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/api/author")
public class AuthorAPI {

    private AuthorService authorService;

    public AuthorAPI(AuthorService authorService){
        this.authorService = authorService;
    }

    @GetMapping
    private Collection<AuthorDTO> getAll(){
        return authorService.getAll();
    }


}
