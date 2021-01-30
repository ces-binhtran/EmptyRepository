package com.ces.training.dao.impl;

import com.ces.training.dao.AuthorDAO;
import com.ces.training.entity.AuthorEntity;
import com.ces.training.utils.ResponseMessage;
import org.hibernate.Session;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.PersistenceContext;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class AuthorDAOImpl implements AuthorDAO {

    @PersistenceContext
    private Session session;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String save(AuthorEntity authorEntity) {
        session.save(authorEntity);
        return ResponseMessage.CREATE_SUCCESSFULLY;
    }

    @Override
    public Set<AuthorEntity> findAll() {
        return new HashSet<>(session.createQuery("from AuthorEntity", AuthorEntity.class).list());
    }

    @Override
    public AuthorEntity getById(Integer id) {
        return session.get(AuthorEntity.class, id);
    }
}
