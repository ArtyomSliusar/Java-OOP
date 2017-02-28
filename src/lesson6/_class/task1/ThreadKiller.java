package lesson6._class.task1;

import java.util.Random;

/**
 * Created by artem on 01.02.17.
 */

public class ThreadKiller implements Runnable {
    private Random rn = new Random();

    public ThreadKiller() {
    }

    @Override
    public void run() {
        Thread st = new Thread(new ShowTime());
        st.start();
        for(int i=rn.nextInt(10); i!=5; i=rn.nextInt(10)) {
            System.out.println("Generate i = "+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        st.interrupt();
    }
}
