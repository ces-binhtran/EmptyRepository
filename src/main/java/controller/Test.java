package controller;

import entity.AuthorEntity;
import entity.BookEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.awt.print.Book;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        BookEntity bookEntity = new BookEntity();
        bookEntity.setName("Harry Potter");
        bookEntity.setId(1);
        AuthorEntity authorEntity = new AuthorEntity();
        authorEntity.setName("Hiep Tran");
        authorEntity.setId(3);
        bookEntity.getAuthors().add(authorEntity);
        authorEntity.getBooks().add(bookEntity);
        try {
            transaction = session.beginTransaction();
            session.update(bookEntity);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
