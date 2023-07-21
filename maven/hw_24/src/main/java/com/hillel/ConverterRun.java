package com.hillel;

public class ConverterRun {
    public static void main(String[] args) {
        FileLoggerConfiguration configuration = new FileLoggerConfiguration("D:\\Other\\" +
                "Hi Course\\homeWork\\maven\\hw_24/logfile.log",
                Level.DEBUG, 1024, "yyyy-MM-dd hh:mm:ss.SSS");
        FileLogger logger = new FileLogger(configuration);

        logger.info("This is an info message.");
        logger.debug("This is a debug message.");
    }
}
