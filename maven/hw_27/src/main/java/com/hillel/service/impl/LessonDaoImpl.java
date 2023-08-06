package com.hillel.service.impl;

import com.hillel.config.DataBaseConnection;
import com.hillel.dto.Homework;
import com.hillel.dto.Lesson;
import com.hillel.mapper.Mapper;
import com.hillel.service.LessonDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LessonDaoImpl implements LessonDao {
    private static final String LESSON_TABLE_NAME = "Lesson";
    private static final String HOMEWORK_TABLE_NAME = "Homework";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_HOMEWORK_ID = "homework_id";
    private static final String HOMEWORK_COLUMN_DESCRIPTION = "description";

    private static final String SELECT_LESSON_BY_ID_QUERY =
            "select * from " + LESSON_TABLE_NAME + " where " + COLUMN_ID + " = ?";
    private static final String SELECT_ALL_LESSONS_QUERY =
            "select * from " + LESSON_TABLE_NAME;
    private static final String INSERT_LESSON_QUERY =
            "insert into " + LESSON_TABLE_NAME + " (" + COLUMN_NAME + ", "
                    + COLUMN_HOMEWORK_ID + ") values (?, ?)";
    private static final String DELETE_LESSON_QUERY =
            "delete from " + LESSON_TABLE_NAME + " where " + COLUMN_ID + " = ?";
    private static final String UPDATE_LESSON_QUERY =
            "update " + LESSON_TABLE_NAME + " set " + COLUMN_NAME + " = ?, "
                    + COLUMN_HOMEWORK_ID + " = ? where " + COLUMN_ID + " = ?";

    private static final String SELECT_HOMEWORK_BY_ID_QUERY =
            "select * from " + HOMEWORK_TABLE_NAME + " where " + COLUMN_ID + " = ?";
    private static final String SELECT_ALL_HOMEWORK_QUERY =
            "select * from " + HOMEWORK_TABLE_NAME;
    private static final String INSERT_HOMEWORK_QUERY =
            "insert into " + HOMEWORK_TABLE_NAME + " (" + COLUMN_NAME + ", "
                    + HOMEWORK_COLUMN_DESCRIPTION + ") values (?, ?)";
    private static final String DELETE_HOMEWORK_QUERY =
            "delete from " + HOMEWORK_TABLE_NAME + " where " + COLUMN_ID + " = ?";
    private static final String UPDATE_HOMEWORK_QUERY =
            "update " + HOMEWORK_TABLE_NAME + " set " + COLUMN_NAME + " = ?, "
                    + HOMEWORK_COLUMN_DESCRIPTION + " = ? where " + COLUMN_ID + " = ?";

    @Override
    public void addLesson(Lesson lesson) {
        try (Connection connection = DataBaseConnection.getConnection();
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
        try (Connection connection = DataBaseConnection.getConnection();
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
        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_LESSONS_QUERY);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Lesson lesson = Mapper.mapLesson(resultSet);
                Homework homework = getHomeworkById(resultSet.getInt(COLUMN_HOMEWORK_ID));
                lesson.setHomework(homework);
                lessons.add(lesson);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lessons;
    }

    @Override
    public Lesson getLessonById(int lessonId) {
        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_LESSON_BY_ID_QUERY)) {

            statement.setInt(1, lessonId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Lesson lesson = Mapper.mapLesson(resultSet);
                    Homework homework = getHomeworkById(resultSet.getInt(COLUMN_HOMEWORK_ID));
                    lesson.setHomework(homework);
                    return lesson;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void updateLesson(Lesson lesson) {
        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_LESSON_QUERY)) {

            statement.setString(1, lesson.getName());
            statement.setInt(2, lesson.getHomework().getId());
            statement.setInt(3, lesson.getId());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addHomework(Homework homework) {
        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_HOMEWORK_QUERY)) {

            statement.setString(1, homework.getName());
            statement.setString(2, homework.getDescription());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteHomework(int homeworkId) {
        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_HOMEWORK_QUERY)) {

            statement.setInt(1, homeworkId);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Homework> getAllHomework() {
        List<Homework> homeworkList = new ArrayList<>();
        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_HOMEWORK_QUERY);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Homework homework = new Homework();
                homework.setId(resultSet.getInt(COLUMN_ID));
                homework.setName(resultSet.getString(COLUMN_NAME));
                homework.setDescription(resultSet.getString(HOMEWORK_COLUMN_DESCRIPTION));
                homeworkList.add(homework);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return homeworkList;
    }

    @Override
    public Homework getHomeworkById(int homeworkId) {
        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_HOMEWORK_BY_ID_QUERY)) {

            statement.setInt(1, homeworkId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Homework homework = new Homework();
                    homework.setId(resultSet.getInt(COLUMN_ID));
                    homework.setName(resultSet.getString(COLUMN_NAME));
                    homework.setDescription(resultSet.getString(HOMEWORK_COLUMN_DESCRIPTION));
                    return homework;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void updateHomework(Homework homework) {
        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_HOMEWORK_QUERY)) {

            statement.setString(1, homework.getName());
            statement.setString(2, homework.getDescription());
            statement.setInt(3, homework.getId());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
