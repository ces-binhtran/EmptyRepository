package com.tranhiep.service;

import com.tranhiep.entity.AuthorEntity;

import java.util.Collection;

public interface AuthorService {

    Collection<AuthorEntity> getAll();
    AuthorEntity getOneById(Integer id);
    AuthorEntity create(AuthorEntity authorEntity);
    AuthorEntity update(AuthorEntity authorEntity);
    void delete(Integer authorId);
    Collection<AuthorEntity> getAllAuthorOfBook(Integer bookId);
    AuthorEntity addAuthorToBook(Integer authorId, Integer bookId);
    void deleteAuthorFromBook(Integer authorId, Integer bookId);
}
