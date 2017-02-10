package lesson7;

/**
 * Created by artem on 06.02.17.
 */

public class Puller implements Runnable {
    private Media media;
    private String text="Pull";
    private boolean turn = false;

    public Puller() {}

    public Puller(Media media) {
        this.media = media;
    }

    @Override
    public void run() {
        for(int i=1; i<=100; i++) {
            media.showText(this.text, this.turn);
        }
    }
}
