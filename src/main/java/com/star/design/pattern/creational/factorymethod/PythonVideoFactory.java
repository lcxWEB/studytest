package com.star.design.pattern.creational.factorymethod;

/**
 * @Author: lcx
 * @Date: 2018/12/10 13:36
 * @Description:
 */

public class PythonVideoFactory extends VideoFactory {

    @Override
    public Video getVideo() {
        return new PythonVideo();
    }
}
