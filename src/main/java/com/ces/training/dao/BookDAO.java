package com.ces.training.dao;

import com.ces.training.entity.BookEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

public interface BookDAO {
    Set<BookEntity> findAll();
    String delete(Integer bookId);
    String save(BookEntity bookEntity, Integer[] ids);
    BookEntity get(Integer bookId);
    String update(BookEntity bookEntity, Integer[] ids);
    Set<BookEntity> findByName(String name);
}
