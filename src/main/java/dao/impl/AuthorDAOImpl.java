package dao.impl;

import dao.AuthorDAO;
import entity.AuthorEntity;
import entity.BookEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;
import utils.ResponseMessage;

import java.util.List;

public class AuthorDAOImpl implements AuthorDAO {
    @Override
    public String addAuthor(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        AuthorEntity authorEntity = new AuthorEntity();
        authorEntity.setName(name);
        try {
            transaction = session.beginTransaction();
            session.save(authorEntity);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return ResponseMessage.ADD_AUTHOR_SUCCESS;
    }

    @Override
    public List<AuthorEntity> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        List<AuthorEntity> authors = null;
        try {
            transaction = session.beginTransaction();
            authors = (List<AuthorEntity>) session.createQuery("from AuthorEntity ", AuthorEntity.class).list();
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return authors;
    }
}
