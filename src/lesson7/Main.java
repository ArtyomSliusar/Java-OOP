package lesson7;

/**
 * Created by artem on 06.02.17.
 */

public class Main {
    public static void main(String[] args) {
        Media media = new Media();
        Thread thrPusher = new Thread(new Pusher(media));
        Thread thrPuller = new Thread(new Puller(media));

        thrPusher.start();
        thrPuller.start();

        try {
            thrPusher.join();
            thrPuller.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("main stop");
    }
}
