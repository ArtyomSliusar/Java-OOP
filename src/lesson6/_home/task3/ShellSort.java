package lesson6._home.task3;

/**
 * Created by artem on 18.02.17.
 */

public class ShellSort implements Runnable {
    private int[] array;
    private Integer h;

    public ShellSort() {
    }

    public ShellSort(int[] intArray) {
        this.array = intArray;
    }

    public ShellSort(int[] array, Integer h) {
        this.array = array;
        setH(h);
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public Integer getH() {
        return h;
    }

    public void setH(Integer h) {
        if(h < 1) {
            System.out.println(String.format("Incorrect h: %d", h));
            System.exit(1);
        }
        this.h = h;
    }

    public void sort() {
        int h = 1;
        while (h*3 < array.length)
            h = h * 3 + 1;

        while(h >= 1) {
            hSort(h);
            h = h/3;
        }
    }

    public void hSort(int h) {
        int t;
        int length = array.length;
        for (int i = h; i < length; i++) {
            for (int j = i; j >= h; j = j - h) {
                if (array[j] < array[j - h]) {
                    t = array[j - h];
                    array[j - h] = array[j];
                    array[j] = t;
                } else {
                    break;
                }
            }
        }
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        hSort(this.h);
    }
}
