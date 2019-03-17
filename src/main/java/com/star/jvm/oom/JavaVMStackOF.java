package com.star.jvm.oom;

/**
 * @Author: lcx
 * @Date: 2019/2/14 14:00
 * @Description:
 */

public class JavaVMStackOF {

    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackOF oom = new JavaVMStackOF();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("Stack length : " + oom.stackLength);
            throw e;
        }
    }

}
