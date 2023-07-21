package com.hillel;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;


public class FileLogger {
    private final FileLoggerConfiguration config;

    public FileLogger(FileLoggerConfiguration config) {
        this.config = config;
    }

    void log(Level level, String message) {
        // 1 - create log file using path, if not exist
        File logFile = new File(config.getPath());

        // 2 - check level
        if ((level == Level.INFO && config.getLevel() == Level.INFO)
                || (level == Level.DEBUG && config.getLevel() == Level.DEBUG)) {

            // 3 - generate log line by pattern: time level message
            String log = String.format("[%s][%s] Message: %s", getCurrentTime(), level, message);

            try (FileWriter fileWriter = new FileWriter(logFile, true)) {
                // 4 - check size > more than max size -> FileMaxSizeReachedException
                long currentFileSize = logFile.length();
                long maxFileSize = config.getMaxFileSize();
                if (currentFileSize >= maxFileSize) {
                    throw new FileMaxSizeReachedException("Max file size reached. Max Size: "
                            + maxFileSize + " bytes, Current Size: " + currentFileSize + " bytes, File Path: "
                            + config.getPath());
                }

                // 5 - write to file + show in console
                System.out.println(log);
                fileWriter.write(log + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    void info(String message) {
        log(Level.INFO, message);
    }

    void debug(String message) {
        log(Level.DEBUG, message);
    }

    private String getCurrentTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(config.getLogFormat());
        return dateFormat.format(new Date());
    }
}
