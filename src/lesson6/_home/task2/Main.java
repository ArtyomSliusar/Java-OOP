package lesson6._home.task2;

import java.time.LocalDateTime;
import java.util.*;


/**
 * Created by artem on 14.02.17.
 */

public class Main {
    public static void main(String[] args) {
        int[] intArray = new int[] {3,2,45,3,4,3,2,45,3,4,3,2,45,3,4,3,2,45,3,4};

        System.out.println("One thread:");
        ArrayIntSum sum = new ArrayIntSum(intArray);
        LocalDateTime start = LocalDateTime.now();
        System.out.println(String.format("Sum result: %s", sum.calculate()));
        long diffInMilli = java.time.Duration.between(start, LocalDateTime.now()).toMillis();
        System.out.println(String.format("Time: %s ms", diffInMilli));
        System.out.println();


        System.out.println("Multi thread:");
        int n = Runtime.getRuntime().availableProcessors();
        Thread[] threadArray = new Thread[n];
        int[] threadResults = new int[n];
        int chunk = (int) Math.ceil((double) intArray.length / n);  // NOTE: array index can't be greater than int

        int thrNum=0;
        for (int pos=0; pos < intArray.length; pos+=chunk, thrNum++) {
            threadArray[thrNum] = new Thread(new ArrayIntSum(intArray, threadResults, pos, pos+chunk));
        }
        start = LocalDateTime.now();
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
        int chunksSum=0;
        for(int i: threadResults) {
            chunksSum+=i;
        }
        System.out.println(String.format("Sum result: %s", chunksSum));
        diffInMilli = java.time.Duration.between(start, LocalDateTime.now()).toMillis();
        System.out.println(String.format("Time: %s ms", diffInMilli));
    }
}
