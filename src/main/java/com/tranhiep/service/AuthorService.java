package com.tranhiep.service;

import com.tranhiep.dao.AuthorDAO;
import com.tranhiep.dao.impl.AuthorDAOImpl;
import com.tranhiep.entity.AuthorEntity;

import java.util.Collection;

public interface AuthorService {

    Collection<AuthorEntity> getAll();
    AuthorEntity getOneById(Integer id);
    AuthorEntity create(AuthorEntity authorEntity);
    AuthorEntity update(AuthorEntity authorEntity);
    void delete(Integer authorId);




}
