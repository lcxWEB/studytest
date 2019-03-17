package com.star.java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * @Author: lcx
 * @Date: 2019/2/18 13:51
 * @Description:
 */

public class TalkingClock {

    private int interval;

    // private boolean beep;

    public TalkingClock(int interval, boolean beep) {
        this.interval = interval;
        // this.beep = beep;
    }

    public void start(int interval, boolean beep) {

        class TimePrinter implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                Date now = new Date();
                System.out.println("At the tone, the time is " + now);
                // if (TalkingClock.this.beep) Toolkit.getDefaultToolkit().beep();
                if (beep) {
                    Toolkit.getDefaultToolkit().beep();
                    System.out.println("aaaa：" + beep);
                }
            }
        }
        ActionListener listener = new TimePrinter();
        // ActionListener listener = this.new TimePrinter();
        Timer timer = new Timer(interval, listener);
        timer.start();

        this.new TimePrinter().actionPerformed(null);
    }

    // public Object start(int interval, boolean beep) {
    //     return null;
    // }

    public class TimePrinter implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Date now = new Date();
            System.out.println("At the tone, the time is " + now);
            // if (TalkingClock.this.beep) Toolkit.getDefaultToolkit().beep();
            new TalkingClock(100, false).start(1000, true);
        }
    }

}
