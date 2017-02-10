package lesson6.task2;

import java.math.BigInteger;

/**
 * Created by artem on 01.02.17.
 */

public class SingleThread implements Runnable {
    private int n;

    public SingleThread() {
        this.n = 10;
    }

    public SingleThread(int n) {
        this.n = n;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    private BigInteger calculateFactorial(int n) {
        BigInteger fact = new BigInteger("1");
        for(int i=2; i<=n; i++) {
            fact = fact.multiply(new BigInteger(""+i));
        }
        return fact;
    }

    @Override
    public void run() {
        Thread thr = Thread.currentThread();
        for(int i=1; i<=n; i++) {
            System.out.println(thr.getName() + " -> " + i + "! =" + calculateFactorial(i));
        }
    }
}
