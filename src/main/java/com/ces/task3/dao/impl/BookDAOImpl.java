package com.ces.task3.dao.impl;

import com.ces.task3.dao.BookDAO;
import com.ces.task3.dao.TypeDAO;
import com.ces.task3.entity.BookEntity;
import com.ces.task3.entity.TypeEntity;
import jdk.nashorn.internal.codegen.TypeMap;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

@Repository
public class BookDAOImpl extends BaseDAOImpl<BookEntity, Integer> implements BookDAO {

    private TypeDAO typeDAO;

    public BookDAOImpl(TypeDAO typeDAO){
        this.typeDAO = typeDAO;
    }

    @Override
    public BookEntity createEntity(BookEntity newEntity) {

        BookEntity book = new BookEntity();
        book.copyValue(newEntity);

        TypeEntity type = typeDAO.getById(newEntity.getType().getId());

        book.setType(type);
        this.entityManager.persist(book);

        return  book;

    }
}
