package com.star.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lcx
 * @Date: 2019/2/14 11:32
 * @Description:
 */

public class HeapOOM {

    private static int test = 1;

    static class OOMObject {

        public void test() {
            test++;
        }
    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();

        while (true) {
            list.add(new OOMObject());
        }
    }

}
