package org.example;

import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class QueryNamed1 {

    public static void main(String[] args) {
        Configuration configuration=new Configuration();
        configuration.configure();
        SessionFactory sessionFactory= configuration.buildSessionFactory();

        Session session= sessionFactory.openSession();

//        TypedQuery

    }

}
