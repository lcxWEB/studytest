package com.star.jvm.excutionEngine;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

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
        // Runnable runnable = () -> byteCodeTest.calc();
        // new Thread(runnable).start();
        // ByteCodeTest byteCodeTest2 = new ByteCodeTest();
        // new Thread(() -> byteCodeTest2.calc()).start();
    }

    public int calc() {
        int a = 100;
        int b = 200;
        int c = 300;
        // synchronized (ByteCodeTest.class) {
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
        // }

        long l = 1L;
        String s = "99uuuuyyy88888";
        Integer integer = 199;
        Integer inte = 110;
        return (a + b) * c;
    }

    public void doSomething() {
        AtomicInteger value = new AtomicInteger();
        // Executors.newSingleThreadExecutor().submit(new Runnable() {
        //     @Override
        //     public void run() {
        //         value++;
        //     }
        // });
        // 为什么转换成一个AtomicInteger就可以了呢？
        // 这跟线程安全没有半毛钱关系，纯粹是利用了这样一个技巧：
        // AtomicInteger可以当作int的容器。因为它是在堆上被分配的，
        // 我们完全没有改变这个局部变量的指向（effectively final成立），
        // 就达到了修改其中数据的目的。
        IntStream.range(1, 10).forEach(i -> value.getAndIncrement());
    }


}
