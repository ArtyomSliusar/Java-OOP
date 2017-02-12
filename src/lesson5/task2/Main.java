package lesson5.task2;

import java.io.*;
import java.util.HashSet;

/**
 * Created by artem on 12.02.17.
 */

public class Main {
    public static void main(String[] args) {
        File fileOne = new File("./src/lesson5/task2/file1.txt");
        File fileTwo = new File("./src/lesson5/task2/file2.txt");

        HashSet<String> intersection = FilesIntersection.getIntersection(fileOne, fileTwo);

        try (FileWriter filesIntersection = new FileWriter("./src/lesson5/task2/filesIntersection.txt")) {
            for(String word: intersection) {
                filesIntersection.write(word+"\n");
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
