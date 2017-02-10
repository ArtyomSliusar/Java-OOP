package lesson7;

/**
 * Created by artem on 06.02.17.
 */

public class Pusher implements Runnable {
    private Media media;
    private String text="Push";
    private boolean turn = true;

    public Pusher() {}

    public Pusher(Media media) {
        this.media = media;
    }

    @Override
    public void run() {
        for(int i=1; i<=100; i++) {
            media.showText(this.text, this.turn);
        }
    }
}
