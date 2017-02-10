package lesson7;

/**
 * Created by artem on 06.02.17.
 */

public class Media {
    private boolean turn = true;

    public Media() {}

    public synchronized void showText(String text, boolean turn) {
        for(; this.turn != turn; ) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(text);
        this.turn = !this.turn;
        notifyAll();
    }
}
