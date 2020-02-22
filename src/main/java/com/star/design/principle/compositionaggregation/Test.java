package com.star.design.principle.compositionaggregation;

/**
 * @Author: lcx
 * @Date: 2018/11/28 14:48
 * @Description:
 */

public class Test {

    public static void main(String[] args) {
        ProductDAO productDAO = new ProductDAO();
        productDAO.setDbConnection(new SQLServerConnection());
        productDAO.addProduct();
    }
}
