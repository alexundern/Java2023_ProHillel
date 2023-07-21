package com.hillel;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FileLoggerConfiguration {
    private final String path; // ../result.log
    private final Level level;
    private final long maxFileSize; // in bytes
    private final String logFormat;
}
