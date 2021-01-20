package com.ces.training.config;

import com.ces.training.dto.AuthorDTO;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ModelAttribute;

@Configuration
public class DefaultAppConfig {

    @ModelAttribute("author")
    public AuthorDTO getDefaultAuthor() {
        return new AuthorDTO();
    }
}
