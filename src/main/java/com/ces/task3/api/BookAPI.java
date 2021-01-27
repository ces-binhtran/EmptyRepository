package com.ces.task3.api;

import com.ces.task3.dto.BookDTO;
import com.ces.task3.entity.BookEntity;
import com.ces.task3.entity.TypeEntity;
import com.ces.task3.model.request.BookRequest;
import com.ces.task3.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/book")
public class BookAPI {

    private BookService bookService;
    private ModelMapper modelMapper;

    public BookAPI(BookService bookService, ModelMapper modelMapper){
        this.bookService = bookService;
        this.modelMapper = modelMapper;
    }

    @PostMapping()
    public BookDTO create(@RequestBody BookRequest book) throws Exception {
        BookEntity newBook = new BookEntity();
        newBook.setName(book.getName());
        TypeEntity type = new TypeEntity();
        type.setId(book.getType());
        newBook.setType(type);
        return bookService.create(newBook)
                .orElseThrow(() -> new Exception("Something error!"));
    }
}
