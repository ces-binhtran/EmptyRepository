package com.tranhiep.dao;


import com.tranhiep.entity.AuthorEntity;

import java.util.Collection;

public interface AuthorDAO extends BaseDAO<AuthorEntity>{

    Collection<AuthorEntity> getAllByBookId(Integer bookId);

    AuthorEntity addAuthorToBook(Integer authorId, Integer bookId);
    void deleteAuthorFromBook(Integer authorId, Integer bookId);
}

