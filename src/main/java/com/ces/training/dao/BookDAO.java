package com.ces.training.dao;

import com.ces.training.entity.BookEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface BookDAO {
    List<BookEntity> findAll();
    String delete(Integer bookId);
    String save(BookEntity bookEntity, Integer[] ids);
    BookEntity get(Integer bookId);
}
