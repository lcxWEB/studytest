package com.star.socket.udp;

/**
 * @Author: lcx
 * @Date: 2019/1/31 17:41
 * @Description:
 */

public class MessageCreator {

    private static final String SN_HEAD = "收到暗号，我是（SN）:";

    private static final String PORT_HEADER = "这是暗号，请回电端口（Port）:";

    public static String buildWithPort(int port) {
        return PORT_HEADER + port;
    }

    public static int parsePort(String data) {
        if (data.startsWith(PORT_HEADER)) {
            return Integer.parseInt(data.substring(PORT_HEADER.length()));
        }
        return -1;
    }

    public static String buildWithSn(String sn) {
        return SN_HEAD + sn;
    }

    public static String parseSn(String data) {
        if (data.startsWith(SN_HEAD)) {
            return data.substring(SN_HEAD.length());
        }
        return null;
    }

}
