package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Configuration cfg=new Configuration();
        cfg.configure();
        SessionFactory sessionFactory=cfg.buildSessionFactory();
//        System.out.println(sessionFactory);

        //One to many as one student can take many courses

        Student student1=new Student();
        student1.setName("Ray");
        student1.setAddress("Australia");
//        student1.setCoursesSet(coursesSet1);

//        Student student2=new Student();
//        student2.setName("Ella");
//        student2.setAddress("Canada");
//      student2.setCoursesSet(coursesSet2);


        Courses course1=new Courses();
        course1.setName("AOP");
        course1.setStudent(student1);
//
        Courses course2=new Courses();
        course2.setName("Data Science");
        course2.setStudent(student1);
//
        Courses course3=new Courses();
        course3.setName("Zoology");
        course3.setStudent(student1);

        Set<Courses> coursesSet1=new HashSet<Courses>();
        coursesSet1.add(course1);
        coursesSet1.add(course2);
        coursesSet1.add(course3);
//
        student1.setCoursesSet(coursesSet1);

//        Set<Courses>coursesSet2=new HashSet<Courses>();
//        coursesSet2.add(course2);
//        coursesSet2.add(course3);

        Session s=sessionFactory.openSession();
//        System.out.println(s);
        Transaction t=s.beginTransaction();

        s.save(student1);
//        s.save(student2);
        s.save(course1);
        s.save(course2);
        s.save(course3);

        t.commit();

        s.close();
    }
}