package com.tranhiep.service.impl;

import com.tranhiep.dao.BookDAO;
import com.tranhiep.dao.impl.BookDAOImpl;
import com.tranhiep.entity.BookEntity;
import com.tranhiep.service.BookService;

import javax.persistence.EntityManager;
import java.util.Collection;


public class BookServiceImpl implements BookService {
    private final EntityManager entityManager;
    private final BookDAO bookDAO;

    public BookServiceImpl(EntityManager entityManager){
        this.entityManager = entityManager;
        bookDAO = new BookDAOImpl(entityManager);
    }


    @Override
    public Collection<BookEntity> getAll() {
        Collection<BookEntity> bookEntities =  bookDAO.getAll(BookEntity.class);
        bookEntities.forEach(e -> e.getAuthors());
        return bookEntities;
    }

    @Override
    public BookEntity getOneById(Integer id) {
        return  bookDAO.getOneById(BookEntity.class, id);
    }

    @Override
    public BookEntity create(BookEntity bookEntity) {
        return bookDAO.create(bookEntity);
    }

    @Override
    public BookEntity update(BookEntity bookEntity) {
        return bookDAO.update(bookEntity);
    }

    @Override
    public void delete(Integer bookId) {
        bookDAO.delete(BookEntity.class, bookId);
    }

    @Override
    public Collection<BookEntity> getAllBookOfAuthor(Integer authorId) {

        return bookDAO.getAllByAuthorId(authorId);
    }
}