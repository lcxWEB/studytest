package com.star.design.pattern.creational.builder.v2;

import com.star.design.pattern.creational.builder.Coach;
import com.star.design.pattern.creational.builder.CourseActualBuilder;
import com.star.design.pattern.creational.builder.CourseBuilder;

/**
 * @Author: lcx
 * @Date: 2018/12/10 16:29
 * @Description:
 */

public class Test {

    public static void main(String[] args) {

        Course course1 = new Course.CourseBuilder()
                .buildCourseName("java").buildCourseArticle("Article").buildCourseQA("QA").build();
        System.out.println(course1);

    }

}
