package lesson6._home.task1;

/**
 * Created by artem on 13.02.17.
 */

public class Main {
    public static void main(String[] args) {
        Thread[] threadArray = new Thread[100];
        for(int i=0; i<100; i++) {
            threadArray[i] = new Thread(new Factorial());
        }
        for(Thread thread: threadArray) {
            thread.start();
        }
        for(Thread thread: threadArray) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("main stop");
    }
}
