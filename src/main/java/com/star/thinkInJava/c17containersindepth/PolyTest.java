package com.star.thinkInJava.c17containersindepth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PolyTest {


    public static void test(List<Map> hashMaps) {
        System.out.println(hashMaps);
    }

    public static void main(String[] args) {
        List<HashMap> maps = new ArrayList<>();
        maps.add(new HashMap());
//        test(maps);
    }
}
