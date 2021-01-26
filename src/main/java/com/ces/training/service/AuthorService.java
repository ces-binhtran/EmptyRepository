package com.ces.training.service;

import com.ces.training.dto.AuthorDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AuthorService {
    String save(AuthorDTO authorDTO);
    List<AuthorDTO> findAll();
}
