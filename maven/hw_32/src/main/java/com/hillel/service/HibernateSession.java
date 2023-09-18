package com.hillel.service;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSession implements AutoCloseable {
    private static final SessionFactory sessionFactory = createSessionFactory();

    private static SessionFactory createSessionFactory() {
        try {
            return new Configuration().configure().buildSessionFactory();
        } catch (Throwable e) {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Override
    public void close(){
        getSessionFactory().close();
    }

}
