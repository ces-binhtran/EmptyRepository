package com.ces.task3.service;

import com.ces.task3.dto.AuthorDTO;
import com.ces.task3.entity.AuthorEntity;
import com.ces.task3.model.exception.NotFoundException;
import com.ces.task3.model.response.Response;

import java.util.Collection;
import java.util.List;

public interface AuthorService extends BaseService<AuthorDTO, AuthorEntity, Integer>{

    Response addAuthorsToBook(Integer bookId, List<Integer> addedAuthorIds) throws NotFoundException;
    Response deleteAuthorsFromBook(Integer bookId, List<Integer> deleteAuthorIds) throws NotFoundException;
    Collection<AuthorDTO> getAuthorsOffBook(Integer bookId);
}
