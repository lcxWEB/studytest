package com.star.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.ServerSocketChannel;

/**
 * @Author: lcx
 * @Date: 2019/1/29 20:57
 * @Description:
 */

public class Server {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(2000);
        System.out.println("服务器准备就绪===");
        System.out.println("服务器信息：" + serverSocket.getInetAddress() + " P：" + serverSocket.getLocalPort());

        for (;;) {
            //等待客户端连接
            Socket client = serverSocket.accept();
            //客户端构建异步线程
            ClientHandler clientHandler = new ClientHandler(client);
            clientHandler.start();
        }

    }

    private static class ClientHandler extends Thread {

        private Socket socket;
        private boolean flag = true;

        ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            System.out.println("新客户端连接：" + socket.getInetAddress() + " P：" + socket.getPort());

            try {
                //打印流，用于数据输出；或服务端回送数据
                PrintStream socketOutput = new PrintStream(socket.getOutputStream());
                //输入流，用于接收数据
                BufferedReader socketInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                do {
                    String str = socketInput.readLine();
                    if ("bye".equalsIgnoreCase(str)) {
                       socketOutput.println("bye");
                       flag = false;
                    } else {
                        System.out.println(str);
                        socketOutput.println(str.length());
                    }
                } while (flag);
                socketInput.close();
                socketOutput.close();

            } catch (Exception e) {
                System.out.println("连接异常断开");
            } finally {
                try {
                    //连接关闭
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("客户端已关闭：" + socket.getInetAddress() + " P:" + socket.getPort());

            }
        }
    }

}
