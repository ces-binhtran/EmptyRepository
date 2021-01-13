package dao.impl;

import dao.BookDAO;
import entity.AuthorEntity;
import entity.BookEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utils.HibernateUtil;
import utils.ResponseMessage;

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

    @Override
    public String save(String name, String[] ids) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        BookEntity bookEntity = new BookEntity();
        bookEntity.setName(name);
        try {
            transaction = session.beginTransaction();
            for(String id : ids) {
                AuthorEntity authorEntity = session.get(AuthorEntity.class, Integer.parseInt(id));
                bookEntity.addAuthor(authorEntity);
//                bookEntity.getAuthors().add(authorEntity);
//                authorEntity.getBooks().add(bookEntity);
            }
            session.save(bookEntity);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
            return ResponseMessage.ADD_BOOK_SUCCESS;
        }
    }
}
