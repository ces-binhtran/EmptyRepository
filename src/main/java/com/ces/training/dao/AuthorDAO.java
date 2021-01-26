package com.ces.training.dao;

import com.ces.training.entity.AuthorEntity;

import java.util.List;

public interface AuthorDAO {
    String save(AuthorEntity authorEntity);
    List<AuthorEntity> findAll();
}
