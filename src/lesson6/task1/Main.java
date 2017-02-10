package lesson6.task1;

/**
 * Created by artem on 01.02.17.
 */
public class Main {
    public static void main(String[] args) {
        Thread t1 = new Thread(new ThreadKiller());
        t1.start();
    }
}
