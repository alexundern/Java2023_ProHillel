package com.hillel.mapper;

import com.hillel.config.DataBaseConnection;
import com.hillel.dto.Homework;
import com.hillel.dto.Lesson;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Mapper {
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String HOMEWORK_TABLE_NAME = "Homework";
    private static final String HOMEWORK_COLUMN_ID = "id";
    private static final String HOMEWORK_COLUMN_NAME = "name";
    private static final String HOMEWORK_COLUMN_DESCRIPTION = "description";
    private static final String LESSON_COLUMN_HOMEWORK_ID = "homework_id";

    public static Lesson mapLesson(ResultSet resultSet) throws SQLException {
        int lessonId = resultSet.getInt(COLUMN_ID);
        String lessonName = resultSet.getString(COLUMN_NAME);
        int homeworkId = resultSet.getInt(LESSON_COLUMN_HOMEWORK_ID);

        Homework homework = getHomeworkById(homeworkId);

        Lesson lesson = new Lesson();
        lesson.setId(lessonId);
        lesson.setName(lessonName);
        lesson.setHomework(homework);

        return lesson;
    }

    private static Homework getHomeworkById(int homeworkId) {
        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement("select * from "
                     + HOMEWORK_TABLE_NAME + " where " + HOMEWORK_COLUMN_ID + " = ?")) {

            statement.setInt(1, homeworkId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String name = resultSet.getString(HOMEWORK_COLUMN_NAME);
                    String description = resultSet.getString(HOMEWORK_COLUMN_DESCRIPTION);

                    Homework homework = new Homework();
                    homework.setId(homeworkId);
                    homework.setName(name);
                    homework.setDescription(description);

                    return homework;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
