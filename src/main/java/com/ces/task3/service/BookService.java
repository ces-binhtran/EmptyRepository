package com.ces.task3.service;

import com.ces.task3.dto.BookDTO;
import com.ces.task3.entity.BookEntity;
import com.ces.task3.model.exception.NotFoundException;

import java.util.Collection;

public interface BookService extends BaseService<BookDTO, BookEntity, Integer> {

    Collection<BookDTO> getAllBookByTypeId(Integer typeId) throws NotFoundException;
    Collection<BookDTO> getAllBookByName(String queryString) throws NotFoundException;
}
