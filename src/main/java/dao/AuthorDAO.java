package dao;

import entity.AuthorEntity;

import java.util.List;

public interface AuthorDAO {
    public String addAuthor(String name);
    public List<AuthorEntity> findAll();
}
