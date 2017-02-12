package lesson5.task2;

import java.util.*;
import java.io.*;

/**
 * Created by artem on 12.02.17.
 */

public class FilesIntersection {

    public static HashSet<String> getIntersection(File file1, File file2) {

        HashSet<String> f1WordsHashSet = new HashSet<>();
        HashSet<String> f2WordsHashSet = new HashSet<>();

        try(BufferedReader f1 = new BufferedReader(new FileReader(file1)); BufferedReader f2 = new BufferedReader(new FileReader(file2))) {
            String line;
            String[] words;
            for(;(line=f1.readLine())!=null;) {
                words = line.split(" ");
                f1WordsHashSet.addAll(Arrays.asList(words));
            }
            for(;(line=f2.readLine())!=null;) {
                words = line.split(" ");
                f2WordsHashSet.addAll(Arrays.asList(words));
            }
        }
        catch(IOException e){
            System.out.println(e);
        }
        f1WordsHashSet.retainAll(f2WordsHashSet);
        return f1WordsHashSet;
    }
}