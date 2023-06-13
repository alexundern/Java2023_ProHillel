package lesson_10.Hw_12;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.Comparator;

public class FileNavigator {
    private Map<String, List<FileData>> fileMap;

    public FileNavigator() {
        fileMap = new HashMap<>();
    }

    public void add(FileData fileData) {
        String filePath = fileData.getFilePath();
        String key = getNormalizedPath(filePath);

        fileMap.computeIfAbsent(key, k -> new ArrayList<>()).add(fileData);
    }

    public List<FileData> find(String filePath) {
        String key = getNormalizedPath(filePath);
        return fileMap.getOrDefault(key, Collections.emptyList());
    }

    public List<FileData> filterBySize(String filePath, long maxSize) {
        String key = getNormalizedPath(filePath);
        List<FileData> fileList = fileMap.getOrDefault(key, Collections.emptyList());
        List<FileData> filteredList = new ArrayList<>();

        for (FileData fileData : fileList) {
            if (fileData.getFileSize() <= maxSize) {
                filteredList.add(fileData);
            }
        }

        return filteredList;
    }

    public void remove(String filePath) {
        String key = getNormalizedPath(filePath);
        fileMap.remove(key);
    }

    public void removeByFileName(String fileName) {
        for (List<FileData> fileList : fileMap.values()) {
            fileList.removeIf(fileData -> fileData.getFileName().equals(fileName));
        }
    }


    public List<FileData> sortBySize() {
        List<FileData> allFiles = new ArrayList<>();

        for (List<FileData> fileList : fileMap.values()) {
            allFiles.addAll(fileList);
        }

        allFiles.sort(Comparator.comparingLong(FileData::getFileSize));

        return allFiles;
    }

        public void addConsistencyCheck(FileData fileData) {
        String path = fileData.getFilePath();
        String key = path.substring(0, path.lastIndexOf("/"));
        List<FileData> fileList = fileMap.getOrDefault(key, new ArrayList<>());
        boolean isConsistent = fileList.stream().anyMatch(file -> file.getFilePath().equals(path));
        if (!isConsistent) {
            System.out.println("Error: Path-key and file path do not match.");
        }
    }

    private String getNormalizedPath(String filePath) {
        return filePath.endsWith("/") ? filePath : filePath + "/";
    }

}
