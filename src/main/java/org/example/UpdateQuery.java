package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateQuery {

    public static void main(String[] args) {


        SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {

            session.beginTransaction();
            session.createQuery("update from Student set email = 'updatedEmail' where id = 10").executeUpdate();
            session.getTransaction().commit();


        } finally {
            sessionFactory.close();
        }

    }
}