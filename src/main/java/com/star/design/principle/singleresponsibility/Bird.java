package com.star.design.principle.singleresponsibility;/**
 * Created by lcx on 2018/11/26.
 */

/**
 * @Author: lcx
 * @Date: 2018/11/26 9:34
 * @Description: TODO
 */

public class Bird {

    public void mainMoveMode(String birdName) {
        if ("鸵鸟".equals(birdName)) {
            System.out.println(birdName + "用脚走");
        } else {
            System.out.println(birdName + "用翅膀飞");
        }
    }
}
