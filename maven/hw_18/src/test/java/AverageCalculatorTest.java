import com.hillel.AverageCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class AverageCalculatorTest {
    @DisplayName("Case 1")
    @Test
    void testCalculateAverage() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        double average = AverageCalculator.calculateAverage(numbers);
        Assertions.assertEquals(3.0, average);
        if (average == 3.0) {
            System.out.println("OK");
        } else {
            System.out.println("NOK");
        }
    }

    @DisplayName("Case 2")
    @Test
    void testCalculateAverageEmptyList() {
        List<Integer> numbers = Arrays.asList();
        double average = AverageCalculator.calculateAverage(numbers);
        Assertions.assertEquals(0.0, average);
        if (average == 0.0) {
            System.out.println("OK");
        } else {
            System.out.println("NOK");
        }
    }
}
