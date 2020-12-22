package com.star.thinkInJava.c15generics;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lichunxia on 2020-02-24 13:44
 */
public class GenericTest {

    public static void add(List list, Object o) {
        list.add(o);
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        add(list, 10);
        print(list);
        String s = list.get(0);

        // 不合法
        List<?> wildList = new ArrayList<>();
        wildList.add(null);

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("11");
        // Error:(29, 16) java: 不兼容的类型: java.util.ArrayList<java.lang.String>无法转换为java.util.ArrayList<java.lang.Object>
        // accept(arrayList);



        Serializable ser = pick("d", new ArrayList<String>());

    }

    static <T> T pick(T a1, T a2) {
        return a2;
    }

    public static void print(List<?> list) {
        for (Object o : list) {
            System.out.println(o);
        }
    }

    public static void accept(ArrayList<Object> al) {
        for (Object o : al)
            System.out.println(o);
    }
}
