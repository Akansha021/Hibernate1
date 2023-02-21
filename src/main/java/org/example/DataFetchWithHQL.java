package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class DataFetchWithHQL {
    public static void main(String[] args) {
        Configuration configuration=new Configuration();
        configuration.configure();
        SessionFactory sessionFactory=configuration.buildSessionFactory();
        Session session=sessionFactory.openSession();

//        Query query=session.createQuery("from Courses");
//        query.setFirstResult(0);
//        query.setFetchSize(2);
//        List<Courses>coursesList=query.list();
//        for(Courses courses:coursesList){
//            System.out.println("Id: "+courses.getId()+" "+"Name: "+courses.getName());
//        }


//        Iterator<Courses> courseIterator=coursesList.iterator();
//        while(courseIterator.hasNext()){
//            System.out.println(courseIterator.next());
//        }

//        for(int i=0;i<coursesList.size();i++){
//            System.out.println(coursesList.get(i));
//        }
            Query query1=session.createQuery("select c.id,c.name from Courses c INNER JOIN Student s on c.student=s.id");
            List<Object[]> studentList=query1.list();

//            Iterator stuIterator= studentList.iterator();
//            List<Object[]>list=query1.getResultList();

//        while(stuIterator.hasNext())
//        {
//            Object rows[] = (Object[])stuIterator.next();
//            System.out.println(rows[0]+ " -- " +rows[1] + "--"+rows[2]+"--"+rows[3]);
//        }


        //To get all the courses taken by a student
        for(Object[] courses:studentList){
            System.out.print("|");
            for(Object c:courses){
                System.out.print(c+"------");
            }
            System.out.println("|");
//            System.out.println(Arrays.toString(courses));
        }

//        for(Student student:studentList){
//            System.out.println("Information: "+student.getId()+","+student.getName()+","+student.getAddress());
//            System.out.println("Courses: "+" ");
//            for( Courses courses: student.getCoursesSet()){
//                System.out.print(courses.getName()+" ");
//            }
//        }





//            for(Object[] arr:list){
//                System.out.println(Arrays.toString(arr));
//            }

//Course Output to get id of courses
        Query query=session.createQuery("select c.id from Courses c");
        List<Object>Student=query.getResultList();
        for (Object student:Student) {
            System.out.println(student);
        }
        session.close();
    }
}
