import com.hillel.SortWords;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortWordsTest {

    @DisplayName("Word sorting test")
    @Test
    public void testSortWords() {
        List<String> strings = Arrays.asList("test", "Banana", "java", "World", "Pear", "Grape", "home");
        List<String> filteredStrings = SortWords.sortWords(strings);

        assertEquals(Arrays.asList("test", "java", "home"), filteredStrings);
        System.out.println("Test passed");
    }
}

