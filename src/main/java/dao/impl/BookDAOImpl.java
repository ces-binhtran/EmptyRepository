package dao.impl;

import dao.BookDAO;
import entity.AuthorEntity;
import entity.BookEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateUtil;
import utils.ResponseMessage;

import java.util.Arrays;
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
            books.forEach(book -> {
                book.getAuthors().size();
            });
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

    @Override
    public String delete(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("delete from BookEntity where id = :id");
            query.setParameter("id", id);
            query.executeUpdate();
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
            return ResponseMessage.DELETE_BOOK_SUCCESS;
        }
    }

    @Override
    public BookEntity findById(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        BookEntity bookEntity = new BookEntity();
        try {
            transaction = session.beginTransaction();
            bookEntity = session.get(BookEntity.class, id);
            bookEntity.getAuthors().size();
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return bookEntity;
    }

    @Override
    public String update(Integer id, String name, String[] ids) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
//            BookEntity bookEntity = new BookEntity();
//            bookEntity.setId(id);
//            bookEntity.setName(name);
//            for(String ele : ids) {
//                AuthorEntity authorEntity = session.get(AuthorEntity.class, Integer.parseInt(ele));
//                bookEntity.addAuthor(authorEntity);
//            }
            System.out.println("--------------------------1");
            BookEntity bookEntity = session.get(BookEntity.class, id);
            System.out.println("--------------------------2");
            List<AuthorEntity> authors = bookEntity.getAuthors();
            System.out.println("--------------------------3");
            authors.forEach(author -> bookEntity.removeAuthor(author));
            System.out.println("--------------------------4");
            for(String ele : ids) {
                AuthorEntity authorEntity = session.get(AuthorEntity.class, Integer.parseInt(ele));
                bookEntity.addAuthor(authorEntity);
            }
//            AuthorEntity authorEntity = session.get(AuthorEntity.class, 3);
//            bookEntity.addAuthor(authorEntity);
//            session.evict(bookEntity);

//            System.out.println("-----------1");
//            bookEntity = session.get(BookEntity.class, id);
//            System.out.println("-----------2");
//            session.persist(bookEntity);
//            System.out.println("-----------3");
//            bookEntity.setName(name);
//            System.out.println("-----------4");
//            bookEntity.getAuthors().removeAll(bookEntity.getAuthors());
//            System.out.println(bookEntity.getAuthors().size());
//            System.out.println("-----------5");
           // BookEntity bookMerge = (BookEntity) session.merge(bookEntity);
            //session.update(bookEntity);
            transaction.commit();
            System.out.println("-----------6");
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
            return ResponseMessage.UPDATE_BOOK_SUCCESS;
        }
    }
}
