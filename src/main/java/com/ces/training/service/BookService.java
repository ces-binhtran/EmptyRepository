package com.ces.training.service;

import com.ces.training.dto.BookDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BookService {
    List<BookDTO> findAll();
    String delete(Integer bookId);
}
