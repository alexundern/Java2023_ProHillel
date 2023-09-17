package com.hillel;

import com.hillel.entity.Student;
import com.hillel.entity.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        try (ConfigurableApplicationContext context = SpringApplication.run(Main.class, args)) {
            StudentService studentService = context.getBean(StudentService.class);

            logger.info("Hibernate");

            Student student1 = new Student("Alex", "alex@mail.com");
            Student student2 = new Student("Denis", "denis@mail.com");
            Student student3 = new Student("Nikita", "nikita@mail.com");
            Student student4 = new Student("Olga", "olga@mail.com");

            logger.info("Add 1-st Student");
            studentService.create(student1);

            logger.info("Add 2-nd Student");
            studentService.create(student2);

            logger.info("Add 3-rd Student");
            studentService.create(student3);

            logger.info("Add 4-th Student");
            studentService.create(student4);

            logger.info("View all Students");
            studentService.getAll().forEach(s -> logger.info(s.toString()));

            logger.info("Update Student");
            student2.setEmail("Change email for denis@mail.com");
            student2.setName("Change name for Dennis");
            logger.info(studentService.update(student2).toString());

            logger.info("View Student with ID 3");
            Student foundStudent = (Student) studentService.get(3L);
            if (foundStudent != null) {
                logger.info("Found: " + foundStudent.toString());
            } else {
                logger.info("Student not found!");
            }

            logger.info("Delete Student with ID 2");
            studentService.delete(foundStudent);
        } catch (Exception e) {
            logger.error("Ошибка при выполнении приложения: " + e.getMessage(), e);
        }
    }
}