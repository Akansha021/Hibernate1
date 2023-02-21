package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DataFetchWithGetLoad1 {
    public static void main(String[] args) {
        Configuration configuration=new Configuration();
        configuration.configure();
        SessionFactory sessionFactory=configuration.buildSessionFactory();

        Session session= sessionFactory.openSession();

        //Using get

        Student student=(Student)session.get(Student.class,1);
        System.out.println(student);

        Student student1=(Student)session.get(Student.class,1);
        System.out.println(student1);

        Student student2=(Student)session.get(Student.class,1);
        System.out.println(student2);


        //Using load

        Student student4=(Student)session.load(Student.class,1);
        System.out.println(student4);

        Student student5=(Student)session.load(Student.class,1);
        System.out.println(student5);

        Student student6=(Student)session.load(Student.class,1);
        System.out.println(student6);


        //get gives null when object not found but load gives objectnotfound exception
        //get performs query when get is used(not when it is fetched) but load perform only when data is called(fetched)
        //use get when not sure whether object exist or not and use load when sure that object exists

        session.close();

    }
}
