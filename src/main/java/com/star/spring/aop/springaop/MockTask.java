package com.star.spring.aop.springaop;

/**
 * @Author: lcx
 * @Date: 2019/2/23 10:25
 * @Description:
 */

public class MockTask implements ITask {

    @Override
    public void execute() {
        System.out.println("task executed.");
    }
}
