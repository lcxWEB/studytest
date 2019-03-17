package com.star.concurrent.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: lcx
 * @Date: 2019/3/10 14:37
 * @Description:
 */

public class Memorizer1<A, V> implements Computable<A, V> {

    private final Map<A, V> cache = new HashMap<>();

    private final Computable<A, V> c;

    public Memorizer1(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public synchronized V compute(A arg) throws InterruptedException {
        V result = cache.get(arg);
        if (result == null) {
            result = c.compute(arg);
            cache.put(arg, result);
        }
        return result;
    }

    public static void main(String[] args) throws InterruptedException {
        Computable<Integer, Integer> c = new Computable<Integer, Integer>() {
            @Override
            public Integer compute(Integer arg) throws InterruptedException {
                return arg + 10;
            }
        };
        Computable<Integer, Integer> cache = new Memorizer1<>(c);
        Integer result = cache.compute(100);
        System.out.println(result);
    }
}
