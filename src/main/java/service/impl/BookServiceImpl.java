package service.impl;

import dao.BookDAO;
import dao.impl.BookDAOImpl;
import entity.BookEntity;
import service.BookService;

import java.util.List;
import java.util.Set;

public class BookServiceImpl implements BookService {
    BookDAO bookDAO = new BookDAOImpl();
    @Override
    public Set<BookEntity> getAllBook() {
        Set<BookEntity> books = bookDAO.getAllBook();
        return books;
    }

    @Override
    public String save(String name, String[] ids) {
        return bookDAO.save(name, ids);
    }

    @Override
    public String delete(Integer id) {
        return bookDAO.delete(id);
    }

    @Override
    public BookEntity findById(Integer id) {
        return bookDAO.findById(id);
    }

    @Override
    public String update(Integer id, String name, String[] ids) {
        return bookDAO.update(id, name, ids);
    }
}
