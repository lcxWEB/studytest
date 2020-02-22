package com.star.design.pattern.creational.singleton;

import java.util.function.Supplier;

/**
 * @Author: lcx
 * @Date: 2019/1/15 10:41
 * @Description:
 */

public class ThreadLocalInstance {

    private static final ThreadLocal<ThreadLocalInstance> threadLocalInstance
            = new ThreadLocal<ThreadLocalInstance>() {
        @Override
        protected ThreadLocalInstance initialValue() {
            return new ThreadLocalInstance();
        }
    };

    private static final ThreadLocal<ThreadLocalInstance> th1 = ThreadLocal.withInitial(new Supplier<ThreadLocalInstance>() {
        @Override
        public ThreadLocalInstance get() {
            return new ThreadLocalInstance();
        }
    });

    private static final ThreadLocal<ThreadLocalInstance> th2 = ThreadLocal.withInitial( () -> new ThreadLocalInstance());

    private ThreadLocalInstance() {

    }

    public static ThreadLocalInstance getIntance() {
        return th2.get();
    }

}
