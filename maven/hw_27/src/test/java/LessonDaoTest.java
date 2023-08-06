import com.hillel.dto.Lesson;
import com.hillel.service.impl.LessonDaoImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LessonDaoTest {
    @Test
    public void testAddLesson() {
        LessonDaoImpl lessonDao = new LessonDaoImpl();

        Lesson lesson = new Lesson();
        lesson.setName("Test Lesson");
        lesson.getHomework().setId(1);

        lessonDao.addLesson(lesson);

        Lesson retrievedLesson = lessonDao.getLessonById(lesson.getId());
        assertNotNull(retrievedLesson);
        assertEquals(lesson.getName(), retrievedLesson.getName());
        assertEquals(lesson.getHomework().getId(), retrievedLesson.getHomework().getId());

        lessonDao.deleteLesson(lesson.getId());
        assertNull(lessonDao.getLessonById(lesson.getId()));
    }

    @Test
    public void testGetAllLessons() {
        LessonDaoImpl lessonDao = new LessonDaoImpl();
        List<Lesson> lessons = lessonDao.getAllLessons();
        assertNotNull(lessons);
        assertTrue(lessons.size() > 0);
    }

    @Test
    public void testUpdateLesson() {
        LessonDaoImpl lessonDao = new LessonDaoImpl();

        Lesson lesson = new Lesson();
        lesson.setName("Original Lesson");
        lesson.getHomework().setId(1);

        lessonDao.addLesson(lesson);

        lesson.setName("Updated Lesson");
        lesson.getHomework().setId(2);
        lessonDao.updateLesson(lesson);

        Lesson updatedLesson = lessonDao.getLessonById(lesson.getId());
        assertNotNull(updatedLesson);
        assertEquals(lesson.getName(), updatedLesson.getName());
        assertEquals(lesson.getHomework().getId(), updatedLesson.getHomework().getId());

        lessonDao.deleteLesson(lesson.getId());
        assertNull(lessonDao.getLessonById(lesson.getId()));
    }

    @Test
    public void testDeleteLesson() {
        LessonDaoImpl lessonDao = new LessonDaoImpl();
        Lesson lesson = new Lesson();
        lesson.setName("Lesson to Delete");
        lesson.getHomework().setId(1);

        lessonDao.addLesson(lesson);

        int lessonId = lesson.getId();
        lessonDao.deleteLesson(lessonId);
        assertNull(lessonDao.getLessonById(lessonId));
    }
}
