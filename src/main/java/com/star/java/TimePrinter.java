package com.star.java;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * @Author: lcx
 * @Date: 2019/2/18 13:28
 * @Description:
 */

public class TimePrinter implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        Date now = new Date();
        System.out.println("At the tone, the time is " + now);
        Toolkit.getDefaultToolkit().beep();
    }

    public static void main(String[] args) {
        ActionListener listener = new TimePrinter();
        javax.swing.Timer t = new javax.swing.Timer(10000, listener);
        t.start();
    }
}
