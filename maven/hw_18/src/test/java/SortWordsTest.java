import com.hillel.SortWords;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortWordsTest {
    @Test
    public void testFilterAndPrint() {
        List<String> strings = Arrays.asList("test", "Banana", "java", "World", "Pear", "Grape", "home");

        List<String> filteredStrings = SortWords.filterAndPrint(strings);

        List<String> expectedStrings = Arrays.asList("test", "java", "home");
        assertEquals(expectedStrings, filteredStrings);
    }
}

