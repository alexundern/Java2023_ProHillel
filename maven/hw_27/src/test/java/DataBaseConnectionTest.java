import static org.junit.jupiter.api.Assertions.*;

import com.hillel.config.DataBaseConnection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.sql.Connection;
import java.sql.SQLException;
public class DataBaseConnectionTest {

    @DisplayName("Connect")
    @Test
    public void testConnection() {
        try {
            Connection connection = DataBaseConnection.getConnection();
            assertNotNull(connection);
            assertFalse(connection.isClosed());
            connection.close();
        } catch (SQLException e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @DisplayName("Close connection")
    @Test
    public void testCloseConnection() {
        try {
            Connection connection = DataBaseConnection.getConnection();
            DataBaseConnection.closeConnection();
            assertTrue(connection.isClosed());
        } catch (SQLException e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }
}
