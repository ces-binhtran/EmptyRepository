//import entity.AuthorEntity;
//import entity.BookEntity;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;
//
//public class App {
//    public static void main(String[] args) {
//        Configuration cf = new Configuration().configure()
//                .addAnnotatedClass(BookEntity.class)
//                .addAnnotatedClass(AuthorEntity.class);
//        SessionFactory sf = cf.buildSessionFactory();
//        Session s = sf.openSession();
//        s.beginTransaction();
//        s.getTransaction().commit();
//    }
//}
