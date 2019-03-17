package com.star.java.generics;

import com.star.java.Employee;
import com.star.java.Manager;
import javassist.compiler.ast.Pair;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: lcx
 * @Date: 2019/3/2 12:01
 * @Description:
 */

public class ArrayAlg {

    public static <T> T getMiddle(T... a) {
        return a[a.length / 2];
    }

    public static <T> T getMiddle() {
        return null;
    }

    public static <T extends Number & Comparable & Serializable> T min(T[] a) {
        if (a == null || a.length == 0) {
            return null;
        }
        T smallest = a[0];
        for (int i = 1; i < a.length; i++) {
            if (smallest.compareTo(a[i]) > 0) {
                smallest = a[i];
            }
        }
        return smallest;

    }

    public static <T extends Comparable> T[] minmax(T... a) {
        // Object[] mm = new Object[2];
        // return (T[])mm;

        T[] mm = (T[]) Array.newInstance(a.getClass().getComponentType(), 2);
        return mm;
    }



    public static void main(String[] args) {
        System.out.println(ArrayAlg.getMiddle("aa", "bb", "cc", 1, new int[]{1, 2, 2}));

        System.out.println(ArrayAlg.getMiddle(3.14, 17.29, 0));

        System.out.println(ArrayAlg.getMiddle(3.14, "ddd", 0, null));

        Object a = ArrayAlg.getMiddle(3.14, "ddd", 0, null);
        // Component c = ArrayAlg.getMiddle(3.14, "ddd", 0, null);

        System.out.println(a);

        System.out.println(ArrayAlg.min(new Integer[]{1, 5, 2, 3}));

        int[] d = new int[]{1, 2, 2};
        System.out.println(d.getClass().getSuperclass());


        List list1 = new ArrayList();
        list1.add("sss");
        list1.add(new HashMap<>());

        List<String> list2 = new ArrayList<>();

        if (list1 instanceof ArrayList) {
            System.out.println("===");
        }

        if (list1 instanceof List) {
            System.out.println("===");
        }
        System.out.println(list1.getClass() == list2.getClass());

        System.out.println(list1.getClass());

        ArrayList<String>[] arrayLists = (ArrayList<String>[]) new ArrayList<?>[10];
        arrayLists[0] = new ArrayList<>();

        // ArrayList<String>[] arrayLists2 = new ArrayList<String>[10]; // error,不能创建泛型数组
        // Object[] objects = arrayLists2;

        ArrayList<Manager>[] table = (ArrayList<Manager>[]) new ArrayList<?>[10];
        table[0] = new ArrayList<>();

        //java.lang.ClassCastException
        String[] ss = minmax("Tom", "Dick", "Harry");
        System.out.println(ss);

        Manager[] managers = {new Manager("dsds"), new Manager("dfdfd")};
        Employee[] employees = managers;
        employees[0] = new Employee();  // java.lang.ArrayStoreException


    }

}
