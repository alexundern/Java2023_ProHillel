import com.hillel.entity.Student;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.List;

import static org.junit.Assert.*;

public class StudentServiceImplTest {
    private static SessionFactory sessionFactory;

    @BeforeClass
    public static void setUp() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    @AfterClass
    public static void tearDown() {
        sessionFactory.close();
    }

    @DisplayName("Create Student")
    @Test
    public void createStudentTest() {
        System.out.println("--- Test: Create Student. ---");

        Student student1 = new Student("Konstantin", "kostya@mail.com");
        Student student2 = new Student("Kate", "kate@mail.com");
        Student student3 = new Student("Olga", "olga@mail.com");
        Student student4 = new Student("Alex", "alex@mail.com");

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(student1);
        session.save(student2);
        session.save(student3);
        session.save(student4);
        session.getTransaction().commit();
        session.close();
        System.out.println("--- End Test: Create Student. ---");
    }

    @DisplayName("Delete Student")
    @Test
    public void delete() {
        createStudentTest();

        System.out.println("--- Test: Delete Student. ---");
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Long testId = 1L;
        Student student = (Student) session.get(Student.class, testId);
        session.delete(student);
        session.getTransaction().commit();
        Student student1 = (Student) session.get(Student.class, testId);
        session.close();
        assertNull(student1);
        System.out.println("--- End Test: Delete Student. ---");
    }

    @DisplayName("Update Student")
    @Test
    public void update() {
        createStudentTest();

        System.out.println("--- Test: Update Student. ---");
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Long testId = 2L;
        Student student = (Student) session.get(Student.class, testId);
        System.out.println("Record from DB is " + student);
        String name = student.getName();
        student.setName(name + " changed");
        session.update(student);
        session.getTransaction().commit();
        System.out.println("Update Student");
        Student student1 = (Student) session.get(Student.class, testId);
        session.close();
        assertNotEquals(name, student1.getName());
        System.out.println("Record from DB is " + student1);
        System.out.println("--- End Test: Update Student. ---");
    }

    @DisplayName("Get all Student")
    @Test
    public void getAll() {
        createStudentTest();
        System.out.println("--- Test: Get all Student. ---");
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Student");
        List<Student> studentList = (List<Student>) query.list();
        System.out.println("List<Student> not null, size = " + studentList.size());
        assertNotEquals(0, studentList.size());
        System.out.println("--- End Test: Get all Student. ---");
    }

    @DisplayName("Get Student for id")
    @Test
    public void get() {
        createStudentTest();
        System.out.println("--- Test: Get Student for id. ---");
        Session session = sessionFactory.openSession();
        Long testId = 2L;
        Student student = (Student) session.get(Student.class, testId);
        System.out.println("Record from DB is " + student);
        assertEquals(testId, student.getId());
        testId = 400L;
        student = (Student) session.get(Student.class, testId);
        assertNull(student);
        System.out.println("--- End Test: Get Student for id. ---");
    }
}