package com.star.java;

import java.awt.event.ActionListener;

/**
 * @Author: lcx
 * @Date: 2019/2/18 13:59
 * @Description:
 */

public class InnerClassTest {

    public static void main(String[] args) {
        TalkingClock talkingClock = new TalkingClock(1000, false);
        talkingClock.start(100, true);
    }
    // TalkingClock.TimePrinter listener = new TalkingClock(1000, true).new TimePrinter();

}
