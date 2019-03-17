package com.star.concurrent.cache;

/**
 * @Author: lcx
 * @Date: 2019/3/10 14:35
 * @Description:
 */

public interface Computable<A, V> {

    V compute(A arg) throws InterruptedException;

}
