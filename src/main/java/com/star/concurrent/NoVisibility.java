package com.star.concurrent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: lcx
 * @Date: 2019/2/25 15:55
 * @Description:
 */

public class NoVisibility {

    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread {
        @Override
        public void run() {
            while (!ready) {
                Thread.yield();
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        new ReaderThread().start();
        number = 42;
        ready = true;
        List a = new ArrayList<>();
        a.add(1);
        List list = Collections.synchronizedList(a);

        System.out.println(list);
    }

}
