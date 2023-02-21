package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class UpdateWithHQL {
    public static void main(String[] args) {
        Configuration configuration=new Configuration();
        configuration.configure();
        SessionFactory sessionFactory=configuration.buildSessionFactory();
        Session session=sessionFactory.openSession();


        Transaction t=session.beginTransaction();
        Query query=session.createQuery("Update Courses c set c.name=:x where c.name=:y ");
        query.setParameter("x","Geography");
        query.setParameter("y","Geo");

        int a=query.executeUpdate();
        System.out.println(a+" "+"Successfully Updated");

        t.commit();
        session.close();
    }
}
