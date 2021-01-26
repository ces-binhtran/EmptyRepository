package service;

import entity.AuthorEntity;

import java.util.List;
import java.util.Set;

public interface AuthorService {
    public String addAuthor(String name);
    public Set<AuthorEntity> getAll();
}
