package lesson6._class.task1;
import java.text.SimpleDateFormat;

/**
 * Created by artem on 01.02.17.
 */

public class ShowTime implements Runnable {
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

    public ShowTime() {
    }

    public ShowTime(SimpleDateFormat sdf) {
        this.sdf = sdf;
    }

    @Override
    public void run() {
        Thread th = Thread.currentThread();
        for(;!th.isInterrupted();) {
            System.out.println(sdf.format(System.currentTimeMillis()));
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
