package com.ces.task3.api;

import com.ces.task3.dto.BookDTO;
import com.ces.task3.entity.BookEntity;
import com.ces.task3.entity.TypeEntity;
import com.ces.task3.model.exception.BadRequestException;
import com.ces.task3.model.exception.NotFoundException;
import com.ces.task3.model.request.BookRequest;
import com.ces.task3.service.BookService;
import com.ces.task3.service.TypeService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/book")
public class BookAPI {

    private BookService bookService;
    private TypeService typeService;
    private ModelMapper modelMapper;

    public BookAPI(BookService bookService,
                   TypeService typeService,
                   ModelMapper modelMapper
    ){
        this.bookService = bookService;
        this.typeService = typeService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/create")
    public BookDTO create(@RequestBody BookRequest book) throws Exception {
        if(book.getName().isEmpty() || book.getType() == null){
            throw BadRequestException.builder("Name", "Type");
        }
        return bookService.create(_copyToBookEntity(book));
    }

    @PostMapping("/edit")
    public BookDTO edit(@RequestBody BookRequest book) throws Throwable {
        if(book.getName().isEmpty() || book.getType() == null){
            throw BadRequestException.builder("Name", "Type");
        }
        return bookService.update(book.getId(), _copyToBookEntity(book));
    }

    protected BookEntity _copyToBookEntity(BookRequest input) throws NotFoundException {
        BookEntity book = new BookEntity();
        book.setId(input.getId());
        book.setName(input.getName());
        TypeEntity type = modelMapper.map(typeService
                .getById(input.getType()), TypeEntity.class);
        book.setType(type);
        return book;
    }
}
