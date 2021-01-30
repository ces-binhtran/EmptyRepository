package com.ces.training.dao.impl;

import com.ces.training.dao.AuthorDAO;
import com.ces.training.dao.BookDAO;
import com.ces.training.entity.AuthorEntity;
import com.ces.training.entity.BookEntity;
import com.ces.training.exception.AppException;
import com.ces.training.utils.ResponseMessage;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.PersistenceContext;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class BookDAOImpl implements BookDAO {

    @PersistenceContext
    private Session session;

    @Autowired
    private AuthorDAO authorDAO;

    @Override
    public Set<BookEntity> findAll() {
        List<BookEntity> bookEntities = session.createQuery("from BookEntity ", BookEntity.class).getResultList();
        bookEntities.forEach(ele -> {
            ele.getAuthors().size();
        });
        return new HashSet<>(bookEntities);
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
            bookEntity.getAuthors().add(authorDAO.getById(id));
        }
        session.save(bookEntity);
        return ResponseMessage.CREATE_SUCCESSFULLY;
    }

    @Override
    public BookEntity get(Integer bookId) {
        BookEntity bookEntity = session.get(BookEntity.class, bookId);
        return bookEntity;
    }

    @Override
    public String update(BookEntity bookEntity, Integer[] ids) {
        for (Integer id: ids) {
            bookEntity.getAuthors().add(authorDAO.getById(id));
        }
        session.update(bookEntity);
        return ResponseMessage.UPDATE_SUCCESSFULLY;
    }

    @Override
    public Set<BookEntity> findByName(String name) {
        Query query = session.createQuery("from BookEntity where name like :name");
        query.setString("name", "%" + name + "%");
        return (Set<BookEntity>) query.list().stream().collect(Collectors.toSet());
    }
}
