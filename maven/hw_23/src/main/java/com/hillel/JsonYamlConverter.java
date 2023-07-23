package com.hillel;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class JsonYamlConverter {

    public static void main(String[] args) {
        String inputDirectoryPath = args.length > 0 ? args[0] : "D:\\Hillel\\hw\\maven\\hw_23\\src\\main\\resources";

        File inputDirectory = new File(inputDirectoryPath);
        File[] files = inputDirectory.listFiles();

        if (files == null) {
            System.out.println("Invalid directory path or empty directory.");
            return;
        }

        File convertedDirectory = new File(inputDirectory, "converted");
        convertedDirectory.mkdir();

        File logFile = new File(inputDirectory, "result.log");
        try (PrintWriter logWriter = new PrintWriter(new FileWriter(logFile, true))) {
            for (File file : files) {
                if (file.isFile()) {
                    String fileName = file.getName();
                    String extension = getFileExtension(fileName);
                    String newExtension = "";

                    if (extension.equals("json")) {
                        newExtension = "yaml";
                        ConverterResult result = FileConverter.convertJsonToYaml(file, new File(convertedDirectory,
                                getNewFileName(fileName, newExtension)));
                        logWriter.println(result);
                    } else if (extension.equals("yaml")) {
                        newExtension = "json";
                        ConverterResult result = FileConverter.convertYamlToJson(file, new File(convertedDirectory,
                                getNewFileName(fileName, newExtension)));
                        logWriter.println(result);
                    } else {
                        logWriter.println(fileName + " -> NOT CONVERTED (Invalid file format)");
                        continue;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getFileExtension(String fileName) {
        int lastDotIndex = fileName.lastIndexOf(".");
        return fileName.substring(lastDotIndex + 1);
    }

    private static String getNewFileName(String fileName, String newExtension) {
        int lastDotIndex = fileName.lastIndexOf(".");
        return fileName.substring(0, lastDotIndex) + "." + newExtension;
    }

}
