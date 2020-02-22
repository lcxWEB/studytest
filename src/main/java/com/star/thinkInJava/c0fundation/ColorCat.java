package com.star.thinkInJava.c0fundation;

public class ColorCat extends Cat {

    private String color;

    public ColorCat(int h, int w, String color) {
        super(h, w);
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Cat))
            return false; //不是Cat或者ColorCat，直接false
        if (!(o instanceof ColorCat))
            return o.equals(this);//不是彩猫，那一定是普通猫，忽略颜色对比
        return super.equals(o) && ((ColorCat) o).color.equals(color); //这时候才比较颜色
    }

}