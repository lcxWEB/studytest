package com.star.thinkInJava.c3operators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.star.thinkInJava.c3operators.Operators.print;

class TestClass2 {

    private TestClass2() {
    }

    TestClass2(int i) {
    }

    public static void main(String[] args) {
        Operators operators = new Operators();

        TestOP test = new TestOP();
        print();

        List<Integer> a = new ArrayList<>();
        a.add(3);
        a.add(1, 10);
        a.add(100);
        a.add(12);
        a.add(199);
        System.out.println(a);
        List b = a.subList(0, 2);
        //ConcurrentModificationException
//        a.add(5);
        a.removeAll(b);
        System.out.println(a);

        b.add(11);
        b.add(199);
        Collections.shuffle(b);
        Collections.sort(b);
        System.out.println(a);

        System.out.println(a.containsAll(b));

        List<Integer> c = new ArrayList<>();
        c.add(199);
        c.add(199);
        c.add(199);
        System.out.println(a.retainAll(b));

        System.out.println(a);

        a.remove(1);
        System.out.println(a);
        a.set(1,222);
        System.out.println(a);

        a.addAll(1, c);
        System.out.println(a);

//        a.clear();
        System.out.println(a);

        System.out.println(c.toArray());

        Integer[] d = {};
        System.out.println(c.toArray(d));
        Integer[] e = c.toArray(d);
        System.out.println(Arrays.toString(d));
        System.out.println(Arrays.toString(e));



    }
}
