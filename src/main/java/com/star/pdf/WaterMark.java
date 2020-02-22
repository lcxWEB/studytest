package com.star.pdf;


import com.spire.pdf.*;

import java.awt.geom.Rectangle2D;

public class WaterMark {

    public static void main(String[] args) {

        //加载PDF文档

        PdfDocument doc = new PdfDocument();
        doc.loadFromFile("/Users/lichunxia/Documents/work/printaction.pdf");

        //获取第一页
        PdfPageBase page = doc.getPages().get(0);

        //设置背景图片
        page.setBackgroundImage("/Users/lichunxia/Documents/work/water.png");
        page.setBackgroudOpacity(1f);

//        //设置背景区域
//        Rectangle2D.Float rect = new Rectangle2D.Float();
//        rect.setRect(280, 300, 150, 150);
//        page.setBackgroundRegion(rect);

        //保存文档
        doc.saveToFile("/Users/lichunxia/Documents/work/test0524.pdf");
        doc.close();

    }
}
