package service.impl;

import dao.AuthorDAO;
import dao.impl.AuthorDAOImpl;
import entity.AuthorEntity;
import service.AuthorService;

import java.util.List;
import java.util.Set;

public class AuthorServiceImpl implements AuthorService {

    @Override
    public String addAuthor(String name) {
        AuthorDAO authorDAO = new AuthorDAOImpl();
        return authorDAO.addAuthor(name);
    }

    @Override
    public Set<AuthorEntity> getAll() {
        AuthorDAO authorDAO = new AuthorDAOImpl();
        return authorDAO.findAll();
    }
}
