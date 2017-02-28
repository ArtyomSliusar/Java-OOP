package lesson6._home.task1;

import java.math.BigInteger;

/**
 * Created by artem on 13.02.17.
 */

public class Factorial implements Runnable {
    private int n;

    public Factorial() {}

    public Factorial(int n) {
        this.n = n;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public BigInteger calculate() {
        if(this.n < 1) {return new BigInteger("0");}
        BigInteger f = new BigInteger("1");
        for(int i=2;i<=this.n; i++) {
            f = f.multiply(new BigInteger(""+i));
        }
        return f;
    }

    @Override
    public void run() {
        String thrName = Thread.currentThread().getName();
        this.setN(Integer.parseInt(thrName.split("-")[1]));
        System.out.println(thrName + " -> " + calculate());
    }
}
