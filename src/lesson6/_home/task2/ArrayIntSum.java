package lesson6._home.task2;

/**
 * Created by artem on 14.02.17.
 */

public class ArrayIntSum implements Runnable {
    private int[] intArray;
    private int[] threadResults;

    public ArrayIntSum() {
    }

    public ArrayIntSum(int[] intArray) {
        this.intArray = intArray;
    }

    public ArrayIntSum(int[] intArray, int[] threadResults) {
        this.intArray = intArray;
        this.threadResults = threadResults;
    }

    public int[] getIntArray() {
        return intArray;
    }

    public void setIntArray(int[] intArray) {
        this.intArray = intArray;
    }

    public int[] getThreadResults() {
        return threadResults;
    }

    public void setThreadResults(int[] threadResults) {
        this.threadResults = threadResults;
    }

    public int calculate() {
        int res=0;
        for(int i: this.intArray) {
            res += i;
        }
        return res;
    }

    @Override
    public void run() {
        int res = calculate();
        String threadName = Thread.currentThread().getName();
        this.threadResults[Integer.parseInt(threadName.split("-")[1])] = res;
    }
}
