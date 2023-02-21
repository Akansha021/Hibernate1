package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Arrays;
import java.util.List;

public class JoinWithHQL {
    public static void main(String[] args) {
        Configuration configuration=new Configuration();
        configuration.configure();
        SessionFactory sessionFactory=configuration.buildSessionFactory();
        Session session=sessionFactory.openSession();

        Query query1=session.createQuery("select s.id,s.name,c.id,c.name from Student s INNER JOIN Courses c on c.student=s.id");
        List<Object[]> listObject1=query1.list();

        System.out.println("INNER JOIN: ");
        for (Object[] obj:listObject1) {
            System.out.println(Arrays.toString(obj));
        }

        Query query2=session.createQuery("select s.id,s.name,c.id,c.name from Student s LEFT JOIN Courses c on c.student=s.id");
        List<Object[]> listObject2=query2.list();

        System.out.println("LEFT JOIN: ");
        for (Object[] obj:listObject2) {
            System.out.println(Arrays.toString(obj));
        }

        Query query3=session.createQuery("select s.id,s.name,c.id,c.name from Student s RIGHT JOIN Courses c on c.student=s.id");
        List<Object[]> listObject3=query3.list();

        System.out.println("RIGHT JOIN: ");
        for (Object[] obj:listObject3) {
            System.out.println(Arrays.toString(obj));
        }

        Query query4=session.createQuery("select s.id,s.name,c.id,c.name from Student s JOIN Courses c on c.student=s.id");
        List<Object[]> listObject4=query4.list();

        System.out.println("OUTER JOIN: ");
        for (Object[] obj:listObject4) {
            System.out.println(Arrays.toString(obj));
        }

        session.close();


    }
}
