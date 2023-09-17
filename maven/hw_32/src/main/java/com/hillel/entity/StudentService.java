package com.hillel.entity;

import java.util.List;

public interface StudentService {

    Long create(Student student);
    void delete (Student student);
    Student update (Student student);
    List<Student> getAll();
    Object get(Long id);

}
