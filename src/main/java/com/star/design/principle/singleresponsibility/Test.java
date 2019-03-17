package com.star.design.principle.singleresponsibility;/**
 * Created by lcx on 2018/11/26.
 */

/**
 * @Author: lcx
 * @Date: 2018/11/26 9:35
 * @Description: TODO
 */

public class Test {

    public static void main(String[] args) {
        // Bird bird = new Bird();
        // bird.mainMoveMode("大雁");
        // bird.mainMoveMode("鸵鸟");

        FlyBird flyBird = new FlyBird();
        flyBird.mainMoveMode("大雁");
        WalkBird walkBird = new WalkBird();
        walkBird.mainMoveMode("鸵鸟");

    }


}