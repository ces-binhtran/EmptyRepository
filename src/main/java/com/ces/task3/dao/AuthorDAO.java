package com.ces.task3.dao;


import com.ces.task3.contrain.ResponseMessage;
import com.ces.task3.entity.AuthorEntity;
import com.ces.task3.model.exception.NotFoundException;
import com.ces.task3.model.response.Response;

import java.util.Collection;
import java.util.List;


public interface AuthorDAO extends  BaseDAO<AuthorEntity, Integer>{

    Response addAuthorsToBook(Integer bookId, List<Integer> addedAuthorIds) throws NotFoundException;
    Response deleteAuthorsFromBook(Integer bookId, List<Integer> deleteAuthorIds) throws NotFoundException;
    Collection<AuthorEntity> getAllAuthorOfBook(Integer bookId);
}
