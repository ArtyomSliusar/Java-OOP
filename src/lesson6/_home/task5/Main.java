package lesson6._home.task5;


/**
 * Created by artem on 15.02.17.
 */

public class Main {
    public static void main(String[] args) {
        String dir = "./src/lesson6/_home/task5/Folder";
        Thread thr1 = new Thread(new FolderWatcher(dir));
        System.out.println("Watching directory: " + dir);
        thr1.start();
        try {
            thr1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Stop main");
    }
}
