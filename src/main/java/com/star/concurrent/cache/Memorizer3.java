package com.star.concurrent.cache;

import com.star.spring.aop.springaop.Executable;

import java.util.Map;
import java.util.concurrent.*;

/**
 * @Author: lcx
 * @Date: 2019/3/10 14:51
 * @Description:
 */

public class Memorizer3<A, V> implements Computable<A, V> {

    private final Map<A, Future<V>> cache = new ConcurrentHashMap<>();

    private final Computable<A, V> c;

    public Memorizer3(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public V compute(A arg) throws InterruptedException {
        Future<V> f = cache.get(arg);
        if (f == null) {
            Callable<V> eval = new Callable<V>() {
                @Override
                public V call() throws Exception {
                    return c.compute(arg);
                }
            };
            FutureTask<V> ft = new FutureTask<>(eval);
            f = ft;
            cache.put(arg, ft);
            ft.run();
        }
        try {
            return f.get();
        } catch (ExecutionException e) {
            throw launcherThrowable(e.getCause());
        }
    }

    public static RuntimeException launcherThrowable(Throwable t) {
        if (t instanceof RuntimeException)
            return (RuntimeException) t;
        else if (t instanceof Error)
            throw (Error) t;
        else
            throw new IllegalStateException("Not unchecked", t);
    }


    public static void main(String[] args) throws InterruptedException {
        Computable<Integer, Integer> c = new Computable<Integer, Integer>() {
            @Override
            public Integer compute(Integer arg) throws InterruptedException {
                return arg + 10;
            }
        };
        Computable<Integer, Integer> cache = new Memorizer3<>(c);
        Integer result = cache.compute(1030);
        System.out.println(result);
    }
}
