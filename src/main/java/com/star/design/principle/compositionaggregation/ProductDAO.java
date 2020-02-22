package com.star.design.principle.compositionaggregation;

/**
 * @Author: lcx
 * @Date: 2018/11/28 14:46
 * @Description:
 */

public class ProductDAO {

    private DBConnection dbConnection;

    public void setDbConnection(DBConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public void addProduct() {
        String conn = dbConnection.getConnection();
        System.out.println("使用" + conn + "增加产品");
    }
}
