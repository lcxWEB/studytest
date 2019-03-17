package com.star.jvm.gc;

/**
 * @Author: lcx
 * @Date: 2019/2/14 20:16
 * @Description:
 */

public class ReferenceCountingGC {

    private Object instance = null;

    private static final int _1M = 1024 * 1024;

    private byte[] bigSize = new byte[2 * _1M];

    public static void main(String[] args) {

        ReferenceCountingGC rcA = new ReferenceCountingGC();
        ReferenceCountingGC rcB = new ReferenceCountingGC();
        rcA.instance = rcB;
        rcB.instance = rcA;

        rcA = null;
        rcB = null;

        System.gc();
    }

}
