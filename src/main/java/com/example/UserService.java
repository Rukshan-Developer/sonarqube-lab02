package main.java.com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UserService {

    private static final String DB_PASSWORD = System.getenv("DB_PASSWORD");

    public void findUser(String username) throws SQLException {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/db", "root", DB_PASSWORD);
             java.sql.PreparedStatement st = conn.prepareStatement("SELECT id, name, email FROM users WHERE name = ?")) {
            st.setString(1, username);
            st.executeQuery();
        }
    }

    public void deleteUser(String username) throws SQLException {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/db", "root", DB_PASSWORD);
             java.sql.PreparedStatement st = conn.prepareStatement("DELETE FROM users WHERE name = ?")) {
            st.setString(1, username);
            st.execute();
        }
    }
}