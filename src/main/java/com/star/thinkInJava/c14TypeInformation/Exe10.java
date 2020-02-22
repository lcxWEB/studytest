package com.star.thinkInJava.c14TypeInformation;

import java.lang.reflect.Proxy;
import java.util.ArrayList;

public class Exe10 {

    public static void main(String[] args) {
        char[] c = new char[10];
        // c is an Object:
        System.out.println("Superclass of char[] c: " +
                c.getClass().getSuperclass());
        System.out.println("char[] c instanceof Object: " +
                (c instanceof Object));
        Hierarchy(new ArrayList<>());

        int i = 0;
        Class<Integer> integerClass = int.class;
        System.out.println(integerClass.getName());

        Class<Integer> aClass = Integer.TYPE;
        System.out.println(aClass.getName());

        Class<? extends Number> numberClass = Integer.class;
//        numberClass = double.class;
        System.out.println(numberClass.isInstance(10));
//        numberClass = String.class;

    }

    public static void Hierarchy(Object o) {
        if(o.getClass().getSuperclass() != null) {
            System.out.println(o.getClass() + " is a subclass of " +
                    o.getClass().getSuperclass());
            try {
                Hierarchy(o.getClass().getSuperclass().newInstance());
            } catch(InstantiationException e) {
                System.out.println("Unable to instantiate obj");
            } catch(IllegalAccessException e) {
                System.out.println("Unable to access");
            }
        }

//        Proxy.newProxyInstance()
    }
}
