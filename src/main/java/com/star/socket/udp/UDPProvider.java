package com.star.socket.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.UUID;

/**
 * @Author: lcx
 * @Date: 2019/1/31 15:50
 * @Description:
 */

public class UDPProvider {

    public static void main(String[] args) throws IOException {

        String sn = UUID.randomUUID().toString();

        Provider provider = new Provider(sn);
        provider.start();

        System.in.read();
        provider.exit();

        // System.out.println("UDPProvider start!");
        // DatagramSocket datagramSocket = new DatagramSocket(20000);
        //
        // final byte[] buf = new byte[512];
        // DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length);
        //
        // datagramSocket.receive(datagramPacket);
        //
        // String ip = datagramPacket.getAddress().getHostAddress();
        // int port = datagramPacket.getPort();
        // int dataLen = datagramPacket.getLength();
        //
        // String data = new String(datagramPacket.getData(), 0, dataLen);
        //
        // System.out.println("UDPProvider receive from ip: " + ip + "\tport: " + port + "\tdata: " + data);
        //
        //
        // String responseData = "Receive data with len: " + dataLen;
        // byte[] responseDataBytes = responseData.getBytes();
        // //回送信息
        // DatagramPacket responsePacket = new DatagramPacket(responseDataBytes, 0,
        //         responseDataBytes.length, datagramPacket.getAddress(), datagramPacket.getPort());
        //
        // datagramSocket.send(responsePacket);
        //
        // System.out.println("UDPProvider finished");
        // datagramSocket.close();
    }


    private static class Provider extends Thread {

        private final String sn;
        private boolean done = false;
        private DatagramSocket ds = null;

        public Provider(String sn) {
            super();
            this.sn = sn;
        }

        @Override
        public void run() {
            super.run();
            System.out.println("UDPProvider start!");
            try {
                // 监听20000端口
                ds = new DatagramSocket(20000);
                while (!done) {
                    final byte[] buf = new byte[512];
                    DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length);

                    ds.receive(datagramPacket);

                    String ip = datagramPacket.getAddress().getHostAddress();
                    int port = datagramPacket.getPort();
                    int dataLen = datagramPacket.getLength();

                    String data = new String(datagramPacket.getData(), 0, dataLen);

                    System.out.println("UDPProvider receive from ip: " + ip + "\tport: " + port + "\tdata: " + data);

                    //解析端口号
                    int responsePort = MessageCreator.parsePort(data);

                    if (responsePort != -1) {
                        String responseData = MessageCreator.buildWithSn(sn);
                        byte[] responseDataBytes = responseData.getBytes();
                        //回送信息
                        DatagramPacket responsePacket = new DatagramPacket(responseDataBytes, 0,
                                responseDataBytes.length, datagramPacket.getAddress(), responsePort);
                        ds.send(responsePacket);
                    }
                }
            } catch (Exception e) {
                // e.printStackTrace();
            } finally {
                close();
            }
            // 完成
            System.out.println("UDPProvider finished");
        }

        private void close() {
            if (ds != null) {
                ds.close();
                ds = null;
            }
        }

        /**
         * 退出
         */
        void exit() {
            done = true;
            close();
        }
    }
}
