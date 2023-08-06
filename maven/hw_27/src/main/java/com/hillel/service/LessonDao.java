package com.hillel.service;

import com.hillel.dto.Homework;
import com.hillel.dto.Lesson;

import java.util.List;

public interface LessonDao {
    void addLesson(Lesson lesson);
    void deleteLesson(int lessonId);
    void updateLesson(Lesson lesson);
    List<Lesson> getAllLessons();
    Lesson getLessonById(int lessonId);

    void addHomework(Homework homework);
    void deleteHomework(int homeworkId);
    void updateHomework(Homework homework);
    List<Homework> getAllHomework();
    Homework getHomeworkById(int homeworkId);
}

