package com.star.java;

/**
 * @Author: lcx
 * @Date: 2019/2/14 19:50
 * @Description:
 */

public class EnumTest {

    public static void main(String[] args) {
        String siz = "SMALL";
        Size size = Enum.valueOf(Size.class, siz);
        System.out.println("size = " + size);
        if (size == Size.MEDIUM) {
            System.out.println("GOOD BYE");
        }
        System.out.println(size.ordinal());

        System.out.println(Size.XSMALL.compareTo(Size.XLARGE));

        Size[] sizes = Size.values();
        for (Size s : sizes) {
            System.out.println(s.toString());
        }

        System.out.println(Size.XLARGE.name());
    }

}
