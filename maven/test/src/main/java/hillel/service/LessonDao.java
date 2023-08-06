package hillel.service;
import hillel.dto.Lesson;

import java.util.List;

public interface LessonDao {
    void addLesson(Lesson lesson);

    void deleteLesson(int lessonId);

    List<Lesson> getAllLessons();

    Lesson getLessonById(int lessonId);
}
