import com.hillel.ArrayUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.Arrays;

public class ArrayUtilsTest {

    @DisplayName("Case 1")
    @Test
    public void testExtractElementsAfterLastFour_case1() {
        int[] input = {1, 2, 4, 4, 2, 3, 4, 1, 7};
        int[] expected = {1, 7};
        int[] result = ArrayUtils.extractElementsAfterLastFour(input);
        assertArrayEquals("Expected: " + arrayToString(expected), expected, result);
        System.out.println("Result: " + Arrays.toString(result));
    }

    @DisplayName("Case 2")
    @Test
    public void testExtractElementsAfterLastFour_case2() {
        int[] input = {4, 1, 2, 3, 4};
        int[] expected = {};
        int[] result = ArrayUtils.extractElementsAfterLastFour(input);
        assertArrayEquals("Expected: " + arrayToString(expected), expected,
                ArrayUtils.extractElementsAfterLastFour(input));
        System.out.println("Result: " + Arrays.toString(result));
    }

    @DisplayName("Case 3")
    @Test
    public void testExtractElementsAfterLastFour_case3() {
        int[] input = {1, 4, 3, 2};
        int[] expected = {3, 2};
        int[] result = ArrayUtils.extractElementsAfterLastFour(input);
        assertArrayEquals("Expected: " + arrayToString(expected), expected,
                ArrayUtils.extractElementsAfterLastFour(input));
        System.out.println("Result: " + Arrays.toString(result));
    }

    @DisplayName("Case 4")
    @Test
    public void testExtractElementsAfterLastFour_case4() {
        int[] input = {1, 2, 3, 5};
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            ArrayUtils.extractElementsAfterLastFour(input);
        });
        String expectedMessage = "Input array does not contain any four";
        System.out.println(exception.getMessage());
        assertEquals(expectedMessage, exception.getMessage());
    }

    private String arrayToString(int[] array) {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0; i < array.length; i++) {
            builder.append(array[i]);
            if (i < array.length - 1) {
                builder.append(", ");
            }
        }
        builder.append("]");
        return builder.toString();
    }

}
