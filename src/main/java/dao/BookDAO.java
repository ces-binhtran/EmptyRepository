package dao;

import entity.BookEntity;

import java.awt.print.Book;
import java.util.List;

public interface BookDAO {
    List<BookEntity> getAllBook();
    String save(String name, String[] ids);
    String delete(Integer id);
    BookEntity findById(Integer id);
    String update(Integer id, String name, String[] ids);
}
