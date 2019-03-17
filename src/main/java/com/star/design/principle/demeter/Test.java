package com.star.design.principle.demeter;

/**
 * @Author: lcx
 * @Date: 2018/11/26 15:57
 * @Description:
 */

public class Test {

    public static void main(String[] args) {
        Boss boss = new Boss();
        TeamLeader teamLeader = new TeamLeader();
        boss.commandCheckNum(teamLeader);
        System.out.println(System.getProperty("user.home"));
    }
}
