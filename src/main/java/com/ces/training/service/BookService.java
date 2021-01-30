package com.ces.training.service;

import com.ces.training.dto.BookDTO;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;
import java.util.Set;

public interface BookService {
    Set<BookDTO> findAll();
    String delete(Integer bookId);
    String save(BookDTO bookDTO, Integer[] ids);
    BookDTO get(Integer bookId);
    String update(BookDTO bookDTO, Integer[] ids);
    Set<BookDTO> findByName(String name);
}
