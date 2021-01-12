package service;

import entity.AuthorEntity;

import java.util.List;

public interface AuthorService {
    public String addAuthor(String name);
    public List<AuthorEntity> getAll();
}
