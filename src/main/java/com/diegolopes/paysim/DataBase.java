package com.diegolopes.paysim;

import javax.persistence.Entity;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DataBase {

    private static DataBase instance;
    public static DataBase get() {
        if (instance == null) {
            instance = new DataBase();
        }
        return instance;
    }

    private SessionFactory factory;

    private DataBase() {
        try {
            factory = new Configuration()
                .configure()
                .buildSessionFactory();
        } catch (HibernateException  e) {
            e.printStackTrace();
        }
    }

    public SessionFactory getFactory() {
        return factory;
    }

    public <T> void create(T object) {
        if (!object.getClass().isAnnotationPresent(Entity.class)) {
            return;
        }

        final Session session = factory.openSession();
        final Transaction tra = session.beginTransaction();
        session.persist(object);
        tra.commit();
        session.close();
    }

}
