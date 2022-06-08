package cn.edu.ccut.db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class BaseHibernateDAO {
    private SessionFactory sessionFactory;

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
