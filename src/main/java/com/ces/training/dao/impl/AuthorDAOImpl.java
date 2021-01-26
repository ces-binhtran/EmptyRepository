package com.ces.training.dao.impl;

import com.ces.training.dao.AuthorDAO;
import com.ces.training.entity.AuthorEntity;
import com.ces.training.utils.ResponseMessage;
import org.hibernate.Session;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class AuthorDAOImpl implements AuthorDAO {

    @PersistenceContext
    private Session session;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String save(AuthorEntity authorEntity) {
        session.save(authorEntity);
        return ResponseMessage.CREATE_AUTHOR_SUCCESSFULLY;
    }

    @Override
    public List<AuthorEntity> findAll() {
        return session.createQuery("from AuthorEntity", AuthorEntity.class).list();
    }
}
