package com.star.thinkInJava.c11holding;

import java.util.ArrayList;
import java.util.List;

class Tester {
    public static int counter = 0;
    private int id = counter++;
    public String toString() { return String.valueOf(id); }
}

public class EX7 {
    public static void main(String[] args) {
        Tester[] t = new Tester[10];
        for(int i = 0; i < t.length; i++)
            t[i] = new Tester();
        List<Tester> lt = new ArrayList<>();
        for(Tester x : t) lt.add(x);
        System.out.println("list of Tester: " + lt);
        List<Tester> sub = lt.subList(2, 6);
        System.out.println("subList: " + sub);
        // produces run time ConcurrentModificationException:
//         lt.removeAll(sub);
        // so, first make copy, remove sub, re-assign lt:
        List<Tester> copy = new ArrayList<Tester>(lt);
        copy.removeAll(sub);
        System.out.println("copy: " + copy);
        lt = copy;
        System.out.println("list of Tester: " + lt);
    }
}
