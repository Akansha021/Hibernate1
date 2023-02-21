package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class DeleteWithHQL {
    public static void main(String[] args) {
        Configuration configuration=new Configuration();
        configuration.configure();
        SessionFactory sessionFactory=configuration.buildSessionFactory();
        Session session=sessionFactory.openSession();


        Transaction t=session.beginTransaction();
        Query query=session.createQuery("Delete from Student s where s.name=:y ");
        query.setParameter("y","Bangkok");

        int a=query.executeUpdate();
        System.out.println(a+" "+"Successfully Updated");

        t.commit();
        session.close();
    }
}
