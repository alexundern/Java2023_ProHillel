package general.lesson_10.hw_12;

public class Main {

    public static void main(String[] args) {
        FileNavigator fileNavigator = new FileNavigator();

        FileData file1 = new FileData("files.txt", 300, "/another/path/to/file");
        FileData file2 = new FileData("files_3.java", 100, "/another/path/to/file");
        FileData file3 = new FileData("files_4.java", 500, "/another/path/to/file");
        FileData file4 = new FileData("files_2.java", 50, "/another/path/to/file");

        fileNavigator.add(file1);
        fileNavigator.add(file2);
        fileNavigator.add(file3);
        fileNavigator.add(file4);

        System.out.println("Files at /another/path/to/file:");
        for (FileData file : fileNavigator.find("/another/path/to/file")) {
            System.out.println(file.getFileName());
        }

        System.out.println("_____________________________");

        System.out.println("Files with size less than or equal to 150 bytes:");
        for (FileData file : fileNavigator.filterBySize("/another/path/to/file", 150)) {
            System.out.println(file.getFileName());
        }

        System.out.println("_____________________________");

        System.out.println("Sorted files by size:");
        for (FileData file : fileNavigator.sortBySize()) {
            System.out.println(file.getFileName());
        }

        System.out.println("_____________________________");

        String fileNameToRemove = "files_4.java";
        fileNavigator.removeByFileName(fileNameToRemove);

        System.out.println("Files at /another/path/to/file after removing files_4.java: ");
        for (FileData file : fileNavigator.find("/another/path/to/file")) {
            System.out.println(file.getFileName());
        }

        System.out.println("_____________________________");

        fileNavigator.remove("/another/path/to/file");
        System.out.println("Files at /another/path/to/file after removal:");
        for (FileData file : fileNavigator.find("/another/path/to/file")) {
            System.out.println(file.getFileName());
        }
    }
}

