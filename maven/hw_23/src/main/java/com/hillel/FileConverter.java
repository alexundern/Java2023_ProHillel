package com.hillel;

import com.google.gson.Gson;
import org.yaml.snakeyaml.Yaml;

import java.io.*;

public class FileConverter {

    public static ConverterResult convertJsonToYaml(File inputFile, File outputFile) throws IOException {
        long startTime = System.currentTimeMillis();

        try (FileInputStream fis = new FileInputStream(inputFile);
             InputStreamReader isr = new InputStreamReader(fis);
             BufferedReader br = new BufferedReader(isr)) {
            StringBuilder jsonStringBuilder = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                jsonStringBuilder.append(line);
            }

            Gson gson = new Gson();
            Object json = gson.fromJson(jsonStringBuilder.toString(), Object.class);

            Yaml yaml = new Yaml();
            String yamlString = yaml.dump(json);

            try (FileWriter fileWriter = new FileWriter(outputFile)) {
                fileWriter.write(yamlString);
            }
        }

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        long originalFileSize = inputFile.length();
        long convertedFileSize = outputFile.length();

        return new ConverterResult(inputFile.getName(), outputFile.getName(), duration,
                originalFileSize, convertedFileSize);
    }

    public static ConverterResult convertYamlToJson(File inputFile, File outputFile) throws IOException {
        long startTime = System.currentTimeMillis();

        try (FileInputStream fis = new FileInputStream(inputFile);
             InputStreamReader isr = new InputStreamReader(fis);
             BufferedReader br = new BufferedReader(isr)) {
            StringBuilder yamlStringBuilder = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                yamlStringBuilder.append(line);
                yamlStringBuilder.append("\n");
            }

            Yaml yaml = new Yaml();
            Object yamlObject = yaml.load(yamlStringBuilder.toString());

            Gson gson = new Gson();
            String jsonString = gson.toJson(yamlObject);

            try (FileWriter fileWriter = new FileWriter(outputFile)) {
                fileWriter.write(jsonString);
            }
        }

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        long originalFileSize = inputFile.length();
        long convertedFileSize = outputFile.length();

        return new ConverterResult(inputFile.getName(), outputFile.getName(), duration,
                originalFileSize, convertedFileSize);
    }

}
