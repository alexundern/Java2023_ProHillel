import com.hillel.ConverterResult;
import com.hillel.FileConverter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

public class FileConverterTest {

    @TempDir
    public Path tempDir;

    @DisplayName("Test convert json to yaml")
    @Test
    public void testConvertJsonToYaml() throws IOException {
        File inputFile = new File(tempDir.toFile(), "input.json");
        File outputFile = new File(tempDir.toFile(), "output.yaml");
        String jsonContent = "{\"name\":\"John\",\"age\":30}";
        FileWriter fileWriter = new FileWriter(inputFile);
        fileWriter.write(jsonContent);
        fileWriter.close();

        ConverterResult result = FileConverter.convertJsonToYaml(inputFile, outputFile);

        assertTrue(outputFile.exists());
        assertEquals(inputFile.getName(), result.getOriginalFileName());
        assertEquals(outputFile.getName(), result.getConvertedFileName());
        assertTrue(result.getConversionDuration() >= 0);
        assertEquals(jsonContent.length(), result.getOriginalFileSize());
        assertTrue(outputFile.length() > 0);
    }

    @DisplayName("Test convert yaml to json ")
    @Test
    public void testConvertYamlToJson() throws IOException {
        File inputFile = new File(tempDir.toFile(), "input.yaml");
        File outputFile = new File(tempDir.toFile(), "output.json");
        String yamlContent = "name: John\nage: 30";
        FileWriter fileWriter = new FileWriter(inputFile);
        fileWriter.write(yamlContent);
        fileWriter.close();

        ConverterResult result = FileConverter.convertYamlToJson(inputFile, outputFile);

        assertTrue(outputFile.exists());
        assertEquals(inputFile.getName(), result.getOriginalFileName());
        assertEquals(outputFile.getName(), result.getConvertedFileName());
        assertTrue(result.getConversionDuration() >= 0);
        assertEquals(yamlContent.length(), result.getOriginalFileSize());
        assertTrue(outputFile.length() > 0);
    }
}
