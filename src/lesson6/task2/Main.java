package lesson6.task2;

/**
 * Created by artem on 01.02.17.
 */

public class Main {
    public static void main(String[] args) {
        int n = Runtime.getRuntime().availableProcessors();
        Thread[] thrArray = new Thread[n];
        int count = 1000;
        for(int i=0; i<thrArray.length; i++) {
            thrArray[i] = new Thread(new SingleThread(count));
        }
        for(Thread thread: thrArray) {
            thread.start();
        }
        for(Thread thread: thrArray) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("main stop");
    }
}
