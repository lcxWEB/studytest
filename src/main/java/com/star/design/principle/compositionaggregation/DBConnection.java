package com.star.design.principle.compositionaggregation;

/**
 * @Author: lcx
 * @Date: 2018/11/28 14:46
 * @Description:
 */

public abstract class DBConnection {
    //
    // public String getConnection() {
    //     return "MySQL数据库连接";
    // }

    public abstract String getConnection();
}
