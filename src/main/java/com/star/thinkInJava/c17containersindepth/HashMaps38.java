package com.star.thinkInJava.c17containersindepth;

import java.util.*;

public class HashMaps38 {
    static List<Test<Map<Integer, String>>> tests =
            new ArrayList<Test<Map<Integer, String>>>();
    static CountingGenerator.String cgs = new CountingGenerator.String(5);

    static {
        tests.add(new Test<Map<Integer, String>>("put") {
            int test(Map<Integer, String> map, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    map.clear();
                    for (int j = 0; j < size; j++)
                        map.put(j, cgs.next());
                }
                return loops * size;
            }
        });
        tests.add(new Test<Map<Integer, String>>("get") {
            int test(Map<Integer, String> map, TestParam tp) {
                int loops = tp.loops;
                int span = tp.size * 2;
                for (int i = 0; i < loops; i++)
                    for (int j = 0; j < span; j++)
                        map.get(j);
                return loops * span;
            }
        });
        tests.add(new Test<Map<Integer, String>>("iterate") {
            int test(Map<Integer, String> map, TestParam tp) {
                int loops = tp.loops * 10;
                for (int i = 0; i < loops; i++) {
                    Iterator it = map.entrySet().iterator();
                    while (it.hasNext()) it.next();
                }
                return loops * map.size();
            }
        });
    }

    public static void main(String[] args) {
        HashMap<Integer, String> map1 = new HashMap<Integer, String>();
        System.out.println("map1: " + map1);
        map1.putAll(new CountingMapData(16));
        System.out.println("map1: " + map1);
        HashMap<Integer, String> map2 = new HashMap<Integer, String>(64);
        System.out.println("map2: " + map2);
        map2.putAll(map1);
        System.out.println("map2: " + map2);
        HashMap<Integer, String> map3 = new HashMap<Integer, String>(1028);
        System.out.println("map3: " + map3);
        map3.putAll(map1);
        System.out.println("map3: " + map3);
        if (args.length > 0)
            Tester.defaultParams = TestParam.array(args);
        else
            Tester.defaultParams = TestParam.array(10, 1000, 100, 1000, 1000, 1000);
        System.out.println("Comparative time tests:");
        Tester.run(map1, tests);
        Tester.run(map2, tests);
        Tester.run(map3, tests);
    }
} 