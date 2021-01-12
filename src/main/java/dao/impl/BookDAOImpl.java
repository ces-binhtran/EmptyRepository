package dao.impl;

import dao.BookDAO;
import entity.BookEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.util.List;

public class BookDAOImpl implements BookDAO {
    @Override
    public List<BookEntity> getAllBook() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        List<BookEntity> books = null;
        try {
            transaction = session.beginTransaction();
            books = (List<BookEntity>) session.createQuery("from BookEntity ", BookEntity.class).list();
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return books;
    }
}
