package dao;

import entity.BookEntity;

import java.util.List;

public interface BookDAO {
    List<BookEntity> getAllBook();
    String save(String name, String[] ids);
}
