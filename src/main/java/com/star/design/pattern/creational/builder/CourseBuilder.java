package com.star.design.pattern.creational.builder;

/**
 * @Author: lcx
 * @Date: 2018/12/10 16:15
 * @Description:
 */

public abstract class CourseBuilder {

    public abstract void buildCourseName(String courseName);
    public abstract void buildCoursePPT(String coursePPT);
    public abstract void buildCourseVideo(String courseVideo);
    public abstract void buildCourseArticle(String courseArticle);
    public abstract void buildCourseQA(String courseQA);

    public abstract Course makeCourse();
}
