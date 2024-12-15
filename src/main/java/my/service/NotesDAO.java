package my.service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NotesDAO {
    public static void add(UserNote user) {
        try {
            String query = "INSERT INTO user_notes (name, timestamp, message) VALUES (?,?,?)";
            Connection connection = UserConfig.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setTimestamp(2, Timestamp.valueOf(user.getTimestamp()));
            preparedStatement.setString(3, user.getMessage());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static List<UserNote> read(String name) {
        List<UserNote> notes = new ArrayList<>();
        String query = "SELECT * FROM user_notes WHERE name = ?";
        try {
            Connection connection = UserConfig.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String nameFromResult = resultSet.getString("name");
                Timestamp timestamp = resultSet.getTimestamp("timestamp");
                String message = resultSet.getString("message");
                UserNote note = new UserNote(name, timestamp.toLocalDateTime(), message);
                notes.add(note);
            }
        } catch (SQLException e) {
            System.out.println("Error getting all notes: " + e.getMessage());
        }
        return notes;

    }

    public static void delete(String name) {
        try {
            String query = "DELETE FROM user_notes WHERE name = ?";
            Connection connection = UserConfig.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
            System.out.println("Записи удалены у пользователя: %s".formatted(name));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
