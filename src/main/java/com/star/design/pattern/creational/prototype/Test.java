package com.star.design.pattern.creational.prototype;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * @Author: lcx
 * @Date: 2019/1/15 14:06
 * @Description:
 */

public class Test {

    public static void main(String[] args) throws CloneNotSupportedException {
        Mail mail = new Mail();
        mail.setContent("初始化模板");
        System.out.println("初始化mail：" + mail);
        for (int i = 0; i < 10; i++){
            Mail mailTemp = (Mail) mail.clone();
            mailTemp.setName("姓名：" + i);
            mailTemp.setEmailAddress("姓名" + i + "@immoc.com");
            mailTemp.setContent("中奖啦！！");
            MailUtil.sendMail(mailTemp);
            System.out.println("克隆的mailTemp：" + mailTemp);
        }
        MailUtil.saveOriginMailRecord(mail);


        String str = "2016-03-04 11:30:40";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
        System.out.println(dateTime);

    }

}
