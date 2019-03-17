package com.star.design.principle.compositionaggregation;

/**
 * @Author: lcx
 * @Date: 2018/11/28 14:50
 * @Description:
 */

public class MySQLConnection extends DBConnection {

    @Override
    public String getConnection() {
        return "MySQL数据库连接";
    }
}
