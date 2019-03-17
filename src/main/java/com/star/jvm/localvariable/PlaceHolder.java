package com.star.jvm.localvariable;

/**
 * @Author: lcx
 * @Date: 2019/3/6 20:22
 * @Description:
 */

public class PlaceHolder {

    public static void main(String[] args) {

        {
            byte[] placeHolder = new byte[64 * 1024 * 1024];
        }

        int i = 0;
        System.gc();
    }

}
