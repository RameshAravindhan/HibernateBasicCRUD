package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


/**
 * Hello world!
 */
public class CreateQuery {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {

            // start a transaction
            session.beginTransaction();

            List<Student> resultList =
                    session.createQuery("from Student s where s.email like '%2code.com'").getResultList();
            // save the student object
            for (Student s : resultList) {
                System.out.println(s.toString());
            }
            // MY NEW CODE

        } finally {
            sessionFactory.close();
        }

        System.out.println("Hello World!");
    }
}
