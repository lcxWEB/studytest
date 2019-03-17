package com.star.design.principle.demeter;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lcx
 * @Date: 2018/11/26 15:52
 * @Description:
 */

public class TeamLeader {

    public void checkNumOfCourse() {
        List<Course> courseList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            courseList.add(new Course());
        }
        System.out.println("在线课程的数量是： " + courseList.size());
    }
}
