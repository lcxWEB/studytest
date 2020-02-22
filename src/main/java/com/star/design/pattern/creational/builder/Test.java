package com.star.design.pattern.creational.builder;

/**
 * @Author: lcx
 * @Date: 2018/12/10 16:29
 * @Description:
 */

public class Test {

    public static void main(String[] args) {
        CourseBuilder courseBuilder = new CourseActualBuilder();
        Coach coach = new Coach();
        coach.setCourseBuilder(courseBuilder);
        Course course = coach.makeCourse("java设计模式", "PPT", "VIDEO",
                "手记", "QA");
        System.out.println(course);

        com.star.design.pattern.creational.builder.v2.Course course1 = new com.star.design.pattern.creational.builder.v2.Course.CourseBuilder()
                .buildCourseName("java").buildCourseArticle("Article").buildCourseQA("QA").build();
        System.out.println(course1);

    }

}
