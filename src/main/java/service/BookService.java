package service;

import entity.BookEntity;

import java.awt.print.Book;
import java.util.List;
import java.util.Set;

public interface BookService {
    Set<BookEntity> getAllBook();
    String save(String name, String[] ids);
    String delete(Integer id);
    BookEntity findById(Integer id);
    String update(Integer id, String name, String[] ids);
}
