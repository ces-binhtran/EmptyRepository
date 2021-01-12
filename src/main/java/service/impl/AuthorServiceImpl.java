package service.impl;

import dao.AuthorDAO;
import dao.impl.AuthorDAOImpl;
import entity.AuthorEntity;
import service.AuthorService;

import java.util.List;

public class AuthorServiceImpl implements AuthorService {

    @Override
    public String addAuthor(String name) {
        AuthorDAO authorDAO = new AuthorDAOImpl();
        return authorDAO.addAuthor(name);
    }

    @Override
    public List<AuthorEntity> getAll() {
        AuthorDAO authorDAO = new AuthorDAOImpl();
        return authorDAO.findAll();
    }
}
