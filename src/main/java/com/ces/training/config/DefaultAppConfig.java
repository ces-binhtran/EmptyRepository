package com.ces.training.config;

import com.ces.training.dto.AuthorDTO;
import com.ces.training.dto.BookDTO;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class DefaultAppConfig {

    @ModelAttribute("author")
    public AuthorDTO getDefaultAuthor() {
        return new AuthorDTO();
    }

    @ModelAttribute("book")
    public BookDTO getDefaultBook() {
        return new BookDTO();
    }
}
