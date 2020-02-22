package com.star.design.pattern.creational.singleton;

import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: lcx
 * @Date: 2019/1/14 19:52
 * @Description:
 */

public class ContainerSingleton {

    private static Map<String, Object> singletonMap = new HashMap();

    public static void putInstance(String key, Object instance) {
        if (!StringUtils.isEmpty(key) && instance != null) {
            if (!singletonMap.containsKey(key)) {
                singletonMap.put(key, instance);
            }
        }
    }

    public static Object getInstance(String key) {
        return singletonMap.get(key);
    }

    private ContainerSingleton() {

    }

}
