package com.star.java;

import java.util.ArrayList;

/**
 * @Author: lcx
 * @Date: 2019/2/18 10:18
 * @Description:
 */

public class ObjectAnalyzerTest {

    public static void main(String[] args) {
        ArrayList<Integer> s = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            s.add(i * i);
        }
        s.clone();
        int[] nums = {1, 2, 3};
        ObjectAnalyzer oa = new ObjectAnalyzer();
        // System.out.println(oa.toString(nums));
        System.out.println(oa.toString(s));
    }

}
