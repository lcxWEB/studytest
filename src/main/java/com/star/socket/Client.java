package com.star.socket;

import java.io.*;
import java.net.*;

/**
 * @Author: lcx
 * @Date: 2019/1/29 20:57
 * @Description:
 */

public class Client {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket();
        socket.setSoTimeout(3000);
        System.out.println(Inet4Address.getLocalHost());
        socket.connect(new InetSocketAddress(Inet4Address.getLocalHost(), 2000), 3000);
        System.out.println("已发起服务器连接，进入后续流程===");
        System.out.println("客户端信息：" + socket.getLocalAddress() + " P：" + socket.getLocalPort());
        System.out.println("服务器信息：" + socket.getInetAddress() + " P：" + socket.getPort());
        try {
            todo(socket);
        } catch (Exception e) {
            System.out.println("异常");
        }
        socket.close();
        System.out.println("客户端已退出");
    }


    private static void todo(Socket client) throws IOException {
        //构建键盘输入流
        InputStream in = System.in;
        BufferedReader input = new BufferedReader(new InputStreamReader(in));

        //得到Socket输出流，转换成打印流
        OutputStream output = client.getOutputStream();
        PrintStream printStream = new PrintStream(output);

        //得到Socket输入流，转换成BufferedReader
        InputStream inputStream = client.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        boolean flag = true;
        do {
            String str= input.readLine();
            //发送到服务器
            printStream.println(str);

            String s = bufferedReader.readLine();
            if ("bye".equalsIgnoreCase(s)) {
                flag = false;
            } else {
                System.out.println(s);
            }
        } while (flag);
        printStream.close();
        bufferedReader.close();
    }

}
