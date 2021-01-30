package com.ces.task3.dao.impl;

import com.ces.task3.dao.BookDAO;
import com.ces.task3.dao.TypeDAO;
import com.ces.task3.entity.BookEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.Collection;

@Repository
public class BookDAOImpl extends BaseDAOImpl<BookEntity, Integer> implements BookDAO {

    private TypeDAO typeDAO;

    public BookDAOImpl(TypeDAO typeDAO){
        this.typeDAO = typeDAO;
    }

    @Override
    public Collection<BookEntity> getAllByType(Integer typeId) {
        TypedQuery<BookEntity> query = entityManager.createNamedQuery("book.getAllByType", BookEntity.class);
        System.out.println("----------------"+ typeId);
        query.setParameter("typeId", typeId);
        return query.getResultList();
    }
}
