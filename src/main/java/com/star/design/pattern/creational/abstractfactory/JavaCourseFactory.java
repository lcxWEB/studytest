package com.star.design.pattern.creational.abstractfactory;

import com.star.design.principle.demeter.Course;

/**
 * @Author: lcx
 * @Date: 2018/12/10 15:41
 * @Description:
 */

public class JavaCourseFactory implements CourseFactory{

    @Override
    public Video getVideo() {
        return new JavaVideo();
    }

    @Override
    public Article getArticle() {
        return new JavaArticle();
    }
}
