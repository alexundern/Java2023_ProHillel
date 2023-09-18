package com.hillel;

import com.hillel.entity.Student;
import com.hillel.entity.StudentService;
import com.hillel.service.HibernateSession;
import com.hillel.service.StudentServiceImpl;
import org.hibernate.SessionFactory;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hibernate");

        SessionFactory sessionFactory = HibernateSession.getSessionFactory();
        StudentService studentService = new StudentServiceImpl(sessionFactory);

        Student student1 = new Student("Konstantin", "kostya@mail.com");
        Student student2 = new Student("Kate", "kate@mail.com");
        Student student3 = new Student("Olga", "olga@mail.com");
        Student student4 = new Student("Alex", "alex@mail.com");

        System.out.println("Add 1-st Student");
        studentService.create(student1);

        System.out.println("Add 2-nd Student");
        studentService.create(student2);

        System.out.println("Add 3-rd Student");
        studentService.create(student3);

        System.out.println("Add 4-th Student");
        studentService.create(student4);

        System.out.println("View all Students");
        studentService.getAll().forEach(System.out::println);

        System.out.println("Update Student");
        student2.setEmail("Change email for ekaterina@Email.com");
        student2.setName("Change name for Ekaterina");
        System.out.println(studentService.update(student2));

        System.out.println("Show 1st Student");
        student1 = (Student) studentService.get(1L);
        if (student1 !=null) {
            System.out.println("Find: " + student1);
        }else {
            System.out.println("Student not found!");
        }
        System.out.println("Delete Student in number 1");
        studentService.delete(student1);

        System.out.println("View all Students");
        studentService.getAll().forEach(System.out::println);
    }
}