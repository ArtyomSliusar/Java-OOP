package lesson6._home.task4;

import java.io.File;
import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * Created by artem on 15.02.17.
 */

public class Main {
    public static void main(String[] args) {
        String srcPath = "./src/lesson6/_home/task4/Folder1/";
        String dstPath = "./src/lesson6/_home/task4/Folder2/";
        File srcFolder = new File(srcPath);
        File destFolder = new File(dstPath);
        if(destFolder.mkdir()) {
            System.out.println("Destination folder created");
        }

        File[] fileList = srcFolder.listFiles();
        if(fileList == null) {
            System.exit(0);
        }

        int n = Runtime.getRuntime().availableProcessors();
        Thread[] threadArray = new Thread[n];
        int chunk = (int) Math.ceil((double) fileList.length / n);  // NOTE: array index can't be greater than int
        int thrNum=0;
        for (int pos=0; pos < fileList.length; pos+=chunk, thrNum++) {
            threadArray[thrNum] = new Thread(new FileCopier(Arrays.copyOfRange(fileList, pos, pos+chunk), dstPath));
        }
        LocalDateTime start = LocalDateTime.now();
        for(Thread thread: threadArray) {
            if(thread != null){
                thread.start();
            }
        }
        for(Thread thread: threadArray) {
            try {
                if(thread != null) {
                    thread.join();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long diffInMilli = java.time.Duration.between(start, LocalDateTime.now()).toMillis();
        System.out.println(String.format("Time: %s ms", diffInMilli));
    }
}

