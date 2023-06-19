import com.hillel.StringConverter;

import javafx.util.Pair;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class StringConverterTest {
    @DisplayName("Case 1")
    @Test
    void testConvertToUpperCase() {
        List<String> strings = Arrays.asList("one", "two", "three", "five");
        List<Pair<String, String>> result = StringConverter.convertToUpperCase(strings);
        List<Pair<String, String>> expected = Arrays.asList(
                new Pair<>("one", "ONE"),
                new Pair<>("two", "TWO"),
                new Pair<>("three", "THREE"),
                new Pair<>("five", "FIVE")
        );
        Assertions.assertTrue(result.containsAll(expected) && expected.containsAll(result), "NOK");
        System.out.println("OK");
    }

    @DisplayName("Case 2")
    @Test
    void testConvertToUpperCaseEmptyList() {
        List<String> strings = Arrays.asList();
        List<Pair<String, String>> result = StringConverter.convertToUpperCase(strings);
        List<Pair<String, String>> expected = Arrays.asList();
        Assertions.assertTrue(result.containsAll(expected) && expected.containsAll(result), "NOK");
        System.out.println("OK");
    }
}
