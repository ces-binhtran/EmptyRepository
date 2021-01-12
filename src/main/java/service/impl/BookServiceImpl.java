package service.impl;

import dao.BookDAO;
import dao.impl.BookDAOImpl;
import entity.BookEntity;
import service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
    @Override
    public List<BookEntity> getAllBook() {
        BookDAO bookDAO = new BookDAOImpl();
        List<BookEntity> books = bookDAO.getAllBook();
        return books;
    }
}
