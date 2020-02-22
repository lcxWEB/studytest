package com.star.jvm.classloading;

/**
 * @Author: lcx
 * @Date: 2019/3/3 17:22
 * @Description:
 */

public class DeadLoopCLass {

    static class StaticTest {
         static {
            if (true) {
                System.out.println(Thread.currentThread() + "init DeadLoopClass");
                while (true) {
                }
            }
        }

    }


    public static void main(String[] args) {
        Runnable script = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread() + "start");
                StaticTest dlc = new StaticTest();
                System.out.println(Thread.currentThread() + "run over");
            }
        };

        Thread thread1 = new Thread(script);
        Thread thread2 = new Thread(script);
        thread1.start();
        thread2.start();
    }

}
