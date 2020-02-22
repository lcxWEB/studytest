package com.star.jvm.excutionEngine;

/**
 * Created by lichunxia on 2020-02-22 15:17
 */
public class ByteCodeTest {

    private String str = "jsjdisdjs";

    public ByteCodeTest() {
        System.out.println(str);
    }

    public static void main(String[] args) {
        ByteCodeTest byteCodeTest = new ByteCodeTest();
        Runnable runnable = () -> byteCodeTest.calc();
        new Thread(runnable).start();
        ByteCodeTest byteCodeTest2 = new ByteCodeTest();
        new Thread(() -> byteCodeTest2.calc()).start();
    }

    public int calc() {
        int a = 100;
        int b = 200;
        int c = 300;
        synchronized (ByteCodeTest.class) {
        // synchronized (this) {
            for (int i = 0; i < a; i++) {
                System.out.println(i);
            }
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("释放锁");
        }

        long l = 1L;
        String s = "99uuuuyyy88888";
        return (a + b) * c;
    }

}
