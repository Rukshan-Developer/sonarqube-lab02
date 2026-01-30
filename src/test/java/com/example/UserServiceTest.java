package main.java.com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private Connection connection;
    
    @Mock
    private PreparedStatement preparedStatement;

    @Test
    void testFindUser() throws SQLException {
        UserService service = new UserService() {
            @Override
            protected Connection getConnection() {
                return connection;
            }
        };

        when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);

        service.findUser("testuser");

        verify(preparedStatement).setString(1, "testuser");
        verify(preparedStatement).executeQuery();
    }
    
    @Test
    void testDeleteUser() throws SQLException {
        UserService service = new UserService() {
            @Override
            protected Connection getConnection() {
                return connection;
            }
        };

        when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);

        service.deleteUser("testuser");

        verify(preparedStatement).setString(1, "testuser");
        verify(preparedStatement).executeUpdate();
    }
}
