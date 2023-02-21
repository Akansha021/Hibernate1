package org.example;

import jakarta.persistence.*;

@Entity
@Table(name = "COURSES")
public class Courses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    ,generator = "gen" (Sequence Strategy)
//    @SequenceGenerator(name = "gen",sequenceName = "seqgen",allocationSize = 1)
    int id;
    String name;


    @ManyToOne(cascade = CascadeType.ALL)
//            (targetEntity = Student.class)
    @JoinColumn(name="sid")
    Student student=new Student();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Courses{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", student=" + student +
                '}';
    }
}
