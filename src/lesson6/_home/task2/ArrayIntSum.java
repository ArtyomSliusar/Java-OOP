package lesson6._home.task2;

/**
 * Created by artem on 14.02.17.
 */

public class ArrayIntSum implements Runnable {
    private int[] intArray;
    private int start;
    private int end;
    private int[] threadResults;

    public ArrayIntSum() {
    }

    public ArrayIntSum(int[] intArray) {
        this.intArray = intArray;
    }

    public ArrayIntSum(int[] intArray, int[] threadResults, int start, int end) {
        this.intArray = intArray;
        this.start = start;
        this.end = end;
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

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int calculate() {
        int res=0;
        if(this.end == 0) {
            this.end = this.intArray.length;
        }
        for(int i=this.start; i < this.end; i++) {
            res += this.intArray[i];
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
