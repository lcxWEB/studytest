package com.star.concurrent.cancelAndclose;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static java.util.concurrent.TimeUnit.SECONDS;

public class PrimeGenerator implements Runnable {

    private final List<BigInteger> primes = new ArrayList<>();

    private volatile boolean cancelled;

    @Override
    public void run() {
        BigInteger p = BigInteger.ONE;
        while (!cancelled) {
            p = p.nextProbablePrime();
            synchronized (this) {
                primes.add(p);
            }
        }
    }

    public void cancel() {
        cancelled = true;
    }

    public synchronized List<BigInteger> get() {
        return new ArrayList<>(primes);
    }

    static List<BigInteger> aSecondOfPrimes() throws InterruptedException {
        PrimeGenerator generator = new PrimeGenerator();
        new Thread(generator).start();
        try {
            SECONDS.sleep(1);
        } finally {
            generator.cancel();
        }
        return generator.get();
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(aSecondOfPrimes());
    }

}
