package lesson_10.Hw_12;

import java.util.*;

public class FileData {

    private String fileName;
    private long fileSize;
    private String filePath;

    public FileData(String fileName, long fileSize, String filePath) {
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.filePath = filePath;
    }

    public String getFileName() {
        return fileName;
    }

    public long getFileSize() {
        return fileSize;
    }

    public String getFilePath() {
        return filePath;
    }
}
