package com.tranhiep.service;

import com.tranhiep.entity.BookEntity;

import java.util.Collection;

public interface BookService {

    Collection<BookEntity> getAll();
    BookEntity getOneById(Integer id);
    BookEntity create(BookEntity bookEntity);
    BookEntity update(BookEntity bookEntity);
    void delete(Integer bookId);
}
