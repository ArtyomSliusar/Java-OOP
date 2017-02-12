package lesson5.task1;

import java.io.File;

/**
 * Created by artem on 12.02.17.
 */

public class Main {
    public static void main(String[] args) {
        String srcPath = "./src/lesson5/task1/Folder1/";
        String dstPath = "./src/lesson5/task1/Folder2/";
        MyFileFilter mFF = new MyFileFilter("doc");
        File srcFolder = new File(srcPath);

        File[] fileList = srcFolder.listFiles(mFF);
        for (File file : fileList) {
            System.out.println(String.format("Copying file: %s to %s", file, dstPath));
            FileCopier.copy(file, new File(dstPath + file.getName()));
        }
    }
}
