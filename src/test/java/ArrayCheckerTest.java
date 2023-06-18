import static org.junit.jupiter.api.Assertions.*;

import com.hillel.ArrayChecker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ArrayCheckerTest {
    @DisplayName("Case 1")
    @Test
    public void testCheckArrayComposition_case1() {
        int[] input = {1, 1, 1, 4, 4, 1, 4, 4};
        assertTrue(ArrayChecker.checkArrayComposition(input));
    }

    @DisplayName("Case 2")
    @Test
    public void testCheckArrayComposition_case2() {
        int[] input = {1, 1, 1, 1, 1, 1};
        assertFalse(ArrayChecker.checkArrayComposition(input));
    }

    @DisplayName("Case 3")
    @Test
    public void testCheckArrayComposition_case3() {
        int[] input = {4, 4, 4, 4};
        assertFalse(ArrayChecker.checkArrayComposition(input));
    }

    @DisplayName("Case 4")
    @Test
    public void testCheckArrayComposition_case4() {
        int[] input = {1, 4, 4, 1, 1, 4, 3};
        assertFalse(ArrayChecker.checkArrayComposition(input));
    }
}
