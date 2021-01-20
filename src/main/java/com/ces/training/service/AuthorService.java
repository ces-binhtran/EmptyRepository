package com.ces.training.service;

import com.ces.training.dto.AuthorDTO;
import org.springframework.stereotype.Service;

public interface AuthorService {
    String save(AuthorDTO authorDTO);
}
