package pl.com.skyline.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import pl.com.skyline.entity.User;
 
public class UserDaoImpl implements UserDao {
 
    private SessionFactory sessionFactory;
 
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
     
    @Override
    public void save(User p) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(p);
        tx.commit();
        session.close();
    }
 
    @SuppressWarnings("unchecked")
    @Override
    public List<User> list() {
        Session session = this.sessionFactory.openSession();
        List<User> userList = session.createQuery("from User").list();
        session.close();
        return userList;
    }
 
}