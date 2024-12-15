package my.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UserConfig {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";
    private final Connection connection;

    private static UserConfig INSTANCE;

    private UserConfig() {
        try {
            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static UserConfig getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new UserConfig();
        }
        return INSTANCE;
    }

    public Connection getConnection() {
        return connection;
    }

    public void initializeDatabase() {
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            String createTableSQL = "CREATE TABLE IF NOT EXISTS user_notes (" +
                    "id SERIAL PRIMARY key," +
                    "name varchar(100)," +
                    "timestamp timestamp," +
                    "message text)";

            statement.execute(createTableSQL);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}