package com.star.socket.udp;

import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @Author: lcx
 * @Date: 2019/1/31 15:51
 * @Description:
 */

public class UDPSearcher {

    private static final int LISTEN_PORT = 30000;

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("UDPSearcher start!");
        // // 系统分配端口
        // DatagramSocket datagramSocket = new DatagramSocket();
        //
        // String request = "Hello world ";
        // byte[] requestBytes = request.getBytes();
        // //回送信息
        // DatagramPacket requestPacket = new DatagramPacket(requestBytes, 0,
        //         requestBytes.length);
        // requestPacket.setAddress(Inet4Address.getLocalHost());
        // requestPacket.setPort(20000);
        //
        // datagramSocket.send(requestPacket);
        //
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
        // System.out.println("UDPSearcher receive from ip: " + ip + "\tport: " + port + "\tdata: " + data);
        // datagramSocket.close();
        //
        Listener listener= listen();
        sendBroadcast();

        System.out.println("UDPSearcher finished");

        System.in.read();
        List<Device> devices = listener.getDevicesAndClose();
        for (Device device : devices) {
            System.out.println("Device: " + device.toString());
        }
    }

    private static Listener listen() throws InterruptedException {
        System.out.println("UDPSearcher start listen");
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Listener listener = new Listener(LISTEN_PORT, countDownLatch);
        listener.start();
        countDownLatch.await();
        return listener;
    }

    private static void sendBroadcast() throws IOException {
        System.out.println("UDPSearcher sendBroadcast start!");
        // 系统分配端口
        DatagramSocket datagramSocket = new DatagramSocket();

        String request = MessageCreator.buildWithPort(LISTEN_PORT);
        byte[] requestBytes = request.getBytes();
        //回送信息
        DatagramPacket requestPacket = new DatagramPacket(requestBytes, 0,
                requestBytes.length);
        // 广播地址
        requestPacket.setAddress(Inet4Address.getByName("255.255.255.255"));
        requestPacket.setPort(20000);

        datagramSocket.send(requestPacket);

        datagramSocket.close();
        System.out.println("UDPSearcher sendBroadcast finished");

    }

    private static class Device {
        final int port;
        final String ip;
        final String sn;

        public Device(int port, String ip, String sn) {
            this.port = port;
            this.ip = ip;
            this.sn = sn;
        }

        @Override
        public String toString() {
            return "Device{" +
                    "port=" + port +
                    ", ip='" + ip + '\'' +
                    ", sn='" + sn + '\'' +
                    '}';
        }
    }

    private static class Listener extends Thread {

        private final int listenPort;

        private final CountDownLatch countDownLatch;

        private final List<Device> deviceList = new ArrayList<>();

        private boolean done = false;

        private DatagramSocket ds = null;

        public Listener(int listenPort, CountDownLatch countDownLatch) {
            super();
            this.listenPort = listenPort;
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            super.run();

            System.out.println("UDPSearcher listener start ");

            //通知已启动
            countDownLatch.countDown();
            try {
                ds = new DatagramSocket(listenPort);
                final byte[] buf = new byte[512];
                DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length);
                //接收
                ds.receive(datagramPacket);

                //打印接收到的信息与发送者的信息
                //发送者的IP地址
                String ip = datagramPacket.getAddress().getHostAddress();
                int port = datagramPacket.getPort();
                int dataLen = datagramPacket.getLength();

                String data = new String(datagramPacket.getData(), 0, dataLen);

                System.out.println("UDPSearcher receive from ip: " + ip + "\tport: " + port + "\tdata: " + data);

                String sn = MessageCreator.parseSn(data);
                if (sn != null) {
                    Device device = new Device(port, ip, sn);
                    deviceList.add(device);
                }

            } catch (Exception e) {

            } finally {
                close();
            }

            System.out.println("UDPSearcher listener finished ");

        }

        private void close() {
            if (ds != null) {
                ds.close();
                ds = null;
            }
        }

        List<Device> getDevicesAndClose() {
            done = true;
            close();
            return deviceList;
        }
    }

}
