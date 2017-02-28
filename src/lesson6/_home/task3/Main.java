package lesson6._home.task3;

import java.time.LocalDateTime;
import java.util.*;


/**
 * Created by artem on 18.02.17.
 */

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[] {3,2,45,3,4,3,2,3,2,45,3,4,3,2,3,2,45,3,4,3,2,3,2,45,3,4,3,3,5,5,6,3,3,2,45,3,4,3,2,3,2,45,3,4,3,2,3,2,45,3,4,3,2,3,2,45,3,4,3,3,5,5,6,3,3,2,45,3,4,3,2,3,2,45,3,4,3,2,3,2,45,3,4,3,2,3,2,45,3,4,3,3,5,5,6,3,3,2,45,3,4,3,2,3,2,45,3,4,3,2,3,2,45,3,4,3,2,3,2,45,3,4,3,3,5,5,6,3};

        System.out.println("One thread:");
        ShellSort ss = new ShellSort(arr);
        LocalDateTime start = LocalDateTime.now();
        ss.sort();
        long diffInMilli = java.time.Duration.between(start, LocalDateTime.now()).toMillis();
        System.out.println(String.format("Result: %s", Arrays.toString(arr)));
        System.out.println(String.format("Time: %s ms", diffInMilli));
        System.out.println();


        arr = new int[] {3,2,45,3,4,3,2,3,2,45,3,4,3,2,3,2,45,3,4,3,2,3,2,45,3,4,3,3,5,5,6,3,3,2,45,3,4,3,2,3,2,45,3,4,3,2,3,2,45,3,4,3,2,3,2,45,3,4,3,3,5,5,6,3,3,2,45,3,4,3,2,3,2,45,3,4,3,2,3,2,45,3,4,3,2,3,2,45,3,4,3,3,5,5,6,3,3,2,45,3,4,3,2,3,2,45,3,4,3,2,3,2,45,3,4,3,2,3,2,45,3,4,3,3,5,5,6,3};
        System.out.println("Multi thread:");
        int n = Runtime.getRuntime().availableProcessors();
        Thread[] threadArray = new Thread[n];
        ArrayList<Integer> steps = new ArrayList<>();
        generateSteps(steps, arr, n);
        for (int j=0; j < steps.size(); j++) {
            threadArray[j] = new Thread(new ShellSort(arr, steps.get(j)));
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
        ss = new ShellSort(arr);
        ss.hSort(1);
        diffInMilli = java.time.Duration.between(start, LocalDateTime.now()).toMillis();
        System.out.println(String.format("Result: %s", Arrays.toString(arr)));
        System.out.println(String.format("Time: %s ms", diffInMilli));
    }

    private static void generateSteps(ArrayList<Integer> steps, int[] arr, int n) {
        int h = 1;
        while (h*3 < arr.length)
            h = h * 3 + 1;
        int i=0;
        while(h > 1 && i < n) {
            boolean isStep = true;
            for(Integer step: steps) {
                if(gcd(step, h) != 1) {
                    isStep = false;
                    break;
                }
            }
            if(isStep) {
                steps.add(h);
                i++;
            }
            h = h/3;
        }
    }

    public static int gcd(int numberOne, int numberTwo) {
        if(numberOne == 0) {
            return numberTwo;
        } else if(numberTwo == 0) {
            return numberOne;
        } else if(numberOne > numberTwo) {
            return gcd(numberOne % numberTwo, numberTwo);
        } else if(numberTwo > numberOne) {
            return gcd(numberTwo % numberOne, numberOne);
        }
        return 1;
    }
}
