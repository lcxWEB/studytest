package com.star.jvm.oom;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @Author: lcx
 * @Date: 2019/2/14 15:25
 * @Description:
 */

public class DirectMemoryOOM {

    private static final int _1M = 1024 * 1024;

    public static void main(String[] args) throws IllegalAccessException {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true) {
            unsafe.allocateMemory(_1M);
        }
    }

}
