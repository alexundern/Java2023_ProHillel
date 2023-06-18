import static org.junit.jupiter.api.Assertions.*;

import com.hillel.SimpleMathLibrary;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;

public class SimpleMathLibraryTest {
    SimpleMathLibrary mathLibrary = new SimpleMathLibrary();

    @DisplayName("Test Plus")
    @Test
    public void add() {

        double result = mathLibrary.add(7.0, 7.5);
        assertEquals(14.5, result, 0.001);
        if (result == 14.5) {
            System.out.println("OK");
        } else {
            System.out.println("NOK");
        }
    }

    @DisplayName("Test Minus")
    @Test
    public void minus() {
        double result = mathLibrary.minus(7.0, 2.5);
        assertEquals(4.5, result, 0.001);
        if (result == 4.5) {
            System.out.println("OK");
        } else {
            System.out.println("NOK");
        }
    }
}
