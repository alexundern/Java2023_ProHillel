package com.hillel;

import com.hillel.dto.Homework;
import com.hillel.dto.Lesson;
import com.hillel.service.LessonDao;
import com.hillel.service.impl.LessonDaoImpl;

import java.util.List;

    public class Main {
        public static void main(String[] args) {
            LessonDao lessonDao = new LessonDaoImpl();

            Homework homework = new Homework();
            homework.setName("Math Homework");
            homework.setDescription("Solve equations");
            lessonDao.addHomework(homework);

            Lesson lesson = new Lesson();
            lesson.setName("Math Lesson");
            lesson.setHomework(homework);
            lessonDao.addLesson(lesson);

            System.out.println("All Lessons:");
            lessonDao.getAllLessons().forEach(System.out::println);

            Lesson retrievedLesson = lessonDao.getLessonById(1);
            System.out.println("\nRetrieved Lesson by ID:");
            System.out.println(retrievedLesson);

            retrievedLesson.setName("Updated Math Lesson");
            lessonDao.updateLesson(retrievedLesson);

            Lesson updatedLesson = lessonDao.getLessonById(1);
            System.out.println("\nUpdated Lesson:");
            System.out.println(updatedLesson);

            lessonDao.deleteLesson(1);

            System.out.println("\nAll Lessons after Deletion:");
            lessonDao.getAllLessons().forEach(System.out::println);
        }

}

