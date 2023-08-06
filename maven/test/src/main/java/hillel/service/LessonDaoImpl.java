package hillel.service;

import hillel.config.DBConnection;
import hillel.dto.Homework;
import hillel.dto.Lesson;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LessonDaoImpl implements LessonDao {

    private static final String TABLE_NAME = "Lesson";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_HOMEWORK_ID = "homework_id";

    private static final String SELECT_LESSON_BY_ID_QUERY =
            "select * from " + TABLE_NAME + " where " + COLUMN_ID + " = ?";
    private static final String SELECT_ALL_LESSONS_QUERY =
            "select * from " + TABLE_NAME;
    private static final String INSERT_LESSON_QUERY =
            "insert into " + TABLE_NAME + " (" + COLUMN_NAME + ", " + COLUMN_HOMEWORK_ID + ") values (?, ?)";
    private static final String DELETE_LESSON_QUERY =
            "delete from " + TABLE_NAME + " where " + COLUMN_ID + " = ?";


    @Override
    public void addLesson(Lesson lesson) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_LESSON_QUERY)) {

            statement.setString(1, lesson.getName());
            statement.setInt(2, lesson.getHomework().getId());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteLesson(int lessonId) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_LESSON_QUERY)) {

            statement.setInt(1, lessonId);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Lesson> getAllLessons() {
        List<Lesson> lessons = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECT_ALL_LESSONS_QUERY)) {

            while (resultSet.next()) {
                int id = resultSet.getInt(COLUMN_ID);
                String name = resultSet.getString(COLUMN_NAME);
                int homeworkId = resultSet.getInt(COLUMN_HOMEWORK_ID);
                Homework homework = getHomeworkById(homeworkId);
                Lesson lesson = new Lesson(id, name, homework);
                lessons.add(lesson);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lessons;
    }

    @Override
    public Lesson getLessonById(int lessonId) {
        Lesson lesson = null;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_LESSON_BY_ID_QUERY)) {

            statement.setInt(1, lessonId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt(COLUMN_ID);
                String name = resultSet.getString(COLUMN_NAME);
                int homeworkId = resultSet.getInt(COLUMN_HOMEWORK_ID);
                Homework homework = getHomeworkById(homeworkId);
                lesson = new Lesson(id, name, homework);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lesson;
    }

    private Homework getHomeworkById(int homeworkId) {
        Homework homework = null;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement("select * from Homework where id = ?")) {

            statement.setInt(1, homeworkId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                homework = new Homework(id, name, description);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return homework;
    }
}
