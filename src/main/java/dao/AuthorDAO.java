package dao;

import entity.AuthorEntity;

import java.util.List;
import java.util.Set;

public interface AuthorDAO {
    public String addAuthor(String name);
    public Set<AuthorEntity> findAll();
}
