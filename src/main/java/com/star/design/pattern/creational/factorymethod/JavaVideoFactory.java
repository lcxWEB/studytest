package com.star.design.pattern.creational.factorymethod;

/**
 * @Author: lcx
 * @Date: 2018/12/10 13:35
 * @Description:
 */

public class JavaVideoFactory extends VideoFactory {

    @Override
    public Video getVideo() {
        return new JavaVideo();
    }
}
