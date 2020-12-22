package com.star;

/**
 * Created by lichunxia on 2020-05-29 20:46
 */
public class InitialTest {

    static char ch;

    static String string = "你好世界";

    public static void main(String[] args) {
        // System.out.println(ch);
        // System.out.println("\\u" + Integer.toHexString(' '));

        for (int i = 0; i < string.length(); i++) {
            System.out.print("\\u" + Integer.toHexString(string.charAt(i)));
        }
    }
}
