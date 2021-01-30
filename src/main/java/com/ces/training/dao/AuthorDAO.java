package com.ces.training.dao;

import com.ces.training.entity.AuthorEntity;

import java.util.List;
import java.util.Set;

public interface AuthorDAO {
    String save(AuthorEntity authorEntity);
    Set<AuthorEntity> findAll();
    AuthorEntity getById(Integer id);
}
