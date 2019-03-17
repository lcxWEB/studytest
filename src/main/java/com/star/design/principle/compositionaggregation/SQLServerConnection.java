package com.star.design.principle.compositionaggregation;

/**
 * @Author: lcx
 * @Date: 2018/11/28 14:51
 * @Description:
 */

public class SQLServerConnection extends DBConnection {

    @Override
    public String getConnection() {
        return "SQLServer数据库连接";
    }

}
