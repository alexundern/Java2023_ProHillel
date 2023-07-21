package com.hillel;

public class FileLoggerConfiguration {
    private final String path; // ../result.log
    private final Level level;
    private final long maxFileSize; // in bytes
    private final String logFormat;

    public FileLoggerConfiguration(String path, Level level, long maxFileSize, String logFormat) {
        this.path = path;
        this.level = level;
        this.maxFileSize = maxFileSize;
        this.logFormat = logFormat;
    }

    public String getPath() {
        return path;
    }

    public Level getLevel() {
        return level;
    }

    public long getMaxFileSize() {
        return maxFileSize;
    }

    public String getLogFormat() {
        return logFormat;
    }
}
