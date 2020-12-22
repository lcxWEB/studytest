package com.star;

/**
 * Created by lichunxia on 2020-06-03 17:55
 */
public class ClassTest {

    static Object[] objects = {};

    public static void main(String[] args) {

        System.out.println((Object) objects.getClass() == (Object) Object[].class);

        String str = "123";
        System.out.println((Object) str.getClass() == (Object) String.class);

        String[] strArr = {};
        System.out.println((Object) strArr.getClass() == (Object) String[].class);
    }
}
