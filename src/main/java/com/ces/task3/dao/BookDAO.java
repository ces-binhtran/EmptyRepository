package com.ces.task3.dao;

import com.ces.task3.entity.BookEntity;

import java.util.Collection;

public interface BookDAO extends BaseDAO<BookEntity, Integer>{

    Collection<BookEntity> getAllByType(Integer typeId);

}
