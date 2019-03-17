package com.star.design.pattern.creational.prototype;

import java.text.MessageFormat;

/**
 * @Author: lcx
 * @Date: 2019/1/15 13:57
 * @Description:
 */

public class MailUtil {

    public static void sendMail(Mail mail) {
        String outputContent = "向{0}，邮件地址:{1}，邮件内容：{2}";

        System.out.println(MessageFormat.format(outputContent, mail.getName(), mail.getEmailAddress(), mail.getContent()));
    }

    public static void saveOriginMailRecord(Mail mail) {
        System.out.println("存储originMail记录， " + mail.getContent());
    }

}
