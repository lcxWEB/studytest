package com.star.jvm.oom;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lcx
 * @Date: 2019/2/14 14:52
 * @Description:
 */

public class RuntimeConstantPoolOOM {

    // public static void main(String[] args) {
    //     List<String> list = new ArrayList<>();
    //     int i = 0;
    //     while (true) {
    //         list.add(String.valueOf(i++).intern());
    //     }
    // }

    public static void main(String[] args) {
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);
    }


}
