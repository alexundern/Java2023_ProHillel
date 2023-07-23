package com.hillel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ConverterResult {

    private String originalFileName;
    private String convertedFileName;
    private long conversionDuration;
    private long originalFileSize;
    private long convertedFileSize;

    @Override
    public String toString() {
        return originalFileName + " -> " + convertedFileName + ", " +
                conversionDuration + " ms, " +
                originalFileSize + " bytes -> " + convertedFileSize + " bytes";
    }
}
