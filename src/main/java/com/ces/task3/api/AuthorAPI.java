package com.ces.task3.api;

import com.ces.task3.contrain.ResponseMessage;
import com.ces.task3.dto.AuthorDTO;
import com.ces.task3.model.exception.BadRequestException;
import com.ces.task3.model.exception.NotFoundException;
import com.ces.task3.model.response.Response;
import com.ces.task3.service.AuthorService;
import com.ces.task3.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/author")
public class AuthorAPI {

    private AuthorService authorService;
    private BookService bookService;

    public AuthorAPI(AuthorService authorService,
                     BookService bookService){
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @GetMapping
    private Collection<AuthorDTO> getAll(){
        return authorService.getAll();
    }


    @PostMapping("/book/{bookId}/add")
    public Response addAuthorsToBook(@RequestBody List<Integer> addedAuthorsId, @PathVariable Integer bookId) throws NotFoundException, BadRequestException {
        if(bookId == null || addedAuthorsId.isEmpty()) throw BadRequestException.builder("authorId", "bookId");
        return authorService.addAuthorsToBook(bookId, addedAuthorsId);
    }

    @PostMapping("/book/{bookId}/delete")
    public Response deleteAuthorsToBook(@RequestBody List<Integer> deleteAuthorsId, @PathVariable Integer bookId) throws NotFoundException, BadRequestException {
        if(bookId == null || deleteAuthorsId.isEmpty()) throw BadRequestException.builder("authorId", "bookId");
        return authorService.deleteAuthorsFromBook(bookId, deleteAuthorsId);
    }

    @GetMapping("/book/{bookId}")
    public Collection<AuthorDTO> getAllAuthorOfBook(@PathVariable Integer bookId) throws BadRequestException {
        if(bookId == null) throw BadRequestException.builder("authorId", "bookId");
        return authorService.getAuthorsOffBook(bookId);
    }
}
