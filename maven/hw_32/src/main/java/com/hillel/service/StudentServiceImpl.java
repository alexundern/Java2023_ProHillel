package com.hillel.service;

import com.hillel.entity.Student;
import com.hillel.entity.StudentService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final SessionFactory sessionFactory;

    @Autowired
    public StudentServiceImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public Long create(Student student) {
        Session session = sessionFactory.getCurrentSession();
        Long id = (Long) session.save(student);
        return id;
    }

    @Override
    @Transactional
    public void delete(Student student) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(student);
    }

    @Override
    @Transactional
    public Student update(Student student) {
        Session session = sessionFactory.getCurrentSession();
        session.update(student);
        return student;
    }

    @Override
    @Transactional
    public List<Student> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return (List<Student>) session.createQuery("from Student");
    }

    @Override
    @Transactional
    public Object get(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Student.class, id);
    }
}