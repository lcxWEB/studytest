package com.star.poi;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.config.Configure;

public class TableTest {

    public static void main(String[] args) {
        Configure.ConfigureBuilder builder = Configure.newBuilder();
        XWPFTemplate.compile("~/template.docx", builder.build());

        builder.customPolicy("report", new CustomTableRenderPolicy());
    }
}
