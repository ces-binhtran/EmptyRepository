package com.tranhiep.dao;

import com.tranhiep.entity.BookEntity;

import java.util.Collection;

public interface BookDAO extends BaseDAO<BookEntity> {
    // some method baseDAO not have

    Collection<BookEntity>getAllByAuthorId(Integer authorId);

}
