package com.ces.training.dao.impl;

import com.ces.training.dao.BookDAO;
import com.ces.training.entity.AuthorEntity;
import com.ces.training.entity.BookEntity;
import com.ces.training.utils.ResponseMessage;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class BookDAOImpl implements BookDAO {

    @PersistenceContext
    private Session session;

    @Override
    public List<BookEntity> findAll() {
        List<BookEntity> bookEntities = null;
        bookEntities = (List<BookEntity>) session.createQuery("from BookEntity ", BookEntity.class).list();
        bookEntities.forEach(ele -> {
            ele.getAuthors().size();
        });
        return bookEntities;
    }

    @Override
    public String delete(Integer bookId) {
        BookEntity bookEntity = session.createQuery("from BookEntity where id = " + bookId, BookEntity.class).uniqueResult();
        session.delete(bookEntity);
        return ResponseMessage.DELETE_SUCCESSFULLY;
    }

    @Override
    public String save(BookEntity bookEntity, Integer[] ids) {
        for(Integer id : ids) {
            bookEntity.getAuthors().add((AuthorEntity) session.createQuery("from AuthorEntity  where id = " + id, AuthorEntity.class).uniqueResult());
        }
        session.save(bookEntity);
        return null;
    }

    @Override
    public BookEntity get(Integer bookId) {
        return session.createQuery("from BookEntity where id = " + bookId, BookEntity.class).uniqueResult();
    }
}
