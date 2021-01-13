package dao.daoimpl;

import dao.AuthorDao;
import entity.AuthorEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AuthorDaoImpl implements AuthorDao {
    @Override
    public AuthorEntity getAuthorById(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.get(AuthorEntity.class,id);
    }

    @Override
    public List<AuthorEntity> getAllAuthors() {
        List<AuthorEntity> list;
        Session session = HibernateUtil.getSessionFactory().openSession();
        String sql = "select * from test.author";
        Query query = session.createNativeQuery(sql, AuthorEntity.class);
        list = query.getResultList();
        return list.stream().sorted(Comparator.comparing(AuthorEntity::getNameAuthor)).collect(Collectors.toList());
    }

    @Override
    public boolean saveAuthor(AuthorEntity authorEntity) {
        if(!checkAuthorNotAvailable(authorEntity)){
            return false;
        }
        boolean result = false;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.save(authorEntity);
            transaction.commit();
            result = true;
        }catch(Exception e){
            e.printStackTrace();
            result = false;
        } finally {
            session.close();
        }
        return result;
    }

    @Override
    public boolean updateAuthor(Integer id,AuthorEntity authorEntity) {
        if(!checkAuthorNotAvailable(authorEntity)){
            return false;
        }
        boolean result = false;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try{
            AuthorEntity authorEntityFind = session.find(AuthorEntity.class,id);
            authorEntityFind.setNameAuthor(authorEntity.getNameAuthor());
            session.update(authorEntityFind);
            transaction.commit();
            result = true;
        }catch (Exception e){
            e.printStackTrace();
            result = false;
        }finally {
            session.close();
        }
        return result;
    }

    @Override
    public boolean deleteAuthor(Integer id) {
        boolean result = false;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            AuthorEntity authorEntity = getAuthorById(id);
            if(authorEntity == null){
                return false;
            }
            session.delete(authorEntity);
            transaction.commit();
            result = true;
        } catch (Exception e){
            e.printStackTrace();
            result = false;
        } finally {
            session.close();
        }
        return result;
    }

    boolean checkAuthorNotAvailable(AuthorEntity authorEntity){
        List<AuthorEntity> list = getAllAuthors();
        AuthorEntity authorCheckedAvailable = list.stream().filter(author -> author.getNameAuthor().equals(authorEntity.getNameAuthor())).findAny().orElse(null);
        return authorCheckedAvailable==null?true:false;
    }
}
