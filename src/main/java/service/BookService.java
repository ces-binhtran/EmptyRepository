package service;

import entity.BookEntity;

import java.util.List;

public interface BookService {
    public List<BookEntity> getAllBook();
    public String save(String name, String[] ids);
}
