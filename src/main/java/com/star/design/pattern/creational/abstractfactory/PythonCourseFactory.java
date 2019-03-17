package com.star.design.pattern.creational.abstractfactory;

/**
 * @Author: lcx
 * @Date: 2018/12/10 15:41
 * @Description:
 */

public class PythonCourseFactory implements CourseFactory{

    @Override
    public Video getVideo() {
        return new PythonVideo();
    }

    @Override
    public Article getArticle() {
        return new PythonArticle();
    }
}
