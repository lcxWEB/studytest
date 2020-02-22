package com.star.java;

/**
 * @Author: lcx
 * @Date: 2019/2/14 19:47
 * @Description:
 */

public enum Size {


    XSMALL("XS"),
    SMALL("S"),
    MEDIUM("M"),
    LARGE("L"),
    XLARGE("XL");

    private String abbr;

    private Size(String abbr) {
        this.abbr = abbr;
    }


}
