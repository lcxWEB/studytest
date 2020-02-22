package com.star.thinkInJava.c18IO;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public class IntBufferDemo {

    private static final int BSIZE = 1024;

    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(BSIZE);
        IntBuffer intBuffer = byteBuffer.asIntBuffer();
        intBuffer.put(new int[]{11, 12, 13, 141, 5, 16});
        System.out.println(intBuffer.get(3));

        intBuffer.put(3, 1001);

        intBuffer.flip();
        while (intBuffer.hasRemaining()) {
            int i = intBuffer.get();
            System.out.println(i);
        }
    }
}
