package utils;

import entity.AuthorEntity;
import entity.BookEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        Configuration cf = new Configuration().configure()
                .addAnnotatedClass(BookEntity.class)
                .addAnnotatedClass(AuthorEntity.class);
        SessionFactory sessionFactory = cf.buildSessionFactory();
        return sessionFactory;
    }
}
