package com.star.thinkInJava.c0fundation;

/**
 * Created by lichunxia on 2020-02-20 13:40
 */
public class EqualsTest {

    public static void main(String[] args) {
        ColorCat whiteCat = new ColorCat(1, 2, "white");
        Cat cat = new Cat(1, 2);
        ColorCat blackCat = new ColorCat(1, 2, "black");
        // 违反传递性
        System.out.println(whiteCat.equals(cat));
        System.out.println(cat.equals(blackCat));
        System.out.println(whiteCat.equals(blackCat));
    }
}
