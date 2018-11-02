package com.qianli.ilink.cloud_platform.messagecenterudp.test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UPDReceive {

    public static void main(String[] args) throws IOException {
        while (true) {
            // 创建数据包传输对象DatagramSocket绑定端口号
            DatagramSocket ds = new DatagramSocket(18873);
            //创建字节数据
            byte[] data = new byte[102400];
            // 创建数据包对象，传递字节数组
            DatagramPacket dp = new DatagramPacket(data, data.length);
            //调用ds对象的方法receive传递数据包
            ds.receive(dp);

            //获取发送端的IP地址对象
            String ip = dp.getAddress().getHostAddress();
            int port = dp.getPort();

            //获取接收到的字节个数
            int length = dp.getLength();
            System.out.println(new String(data, 0, length) + "........." + ip + ":" + port);
            ds.close();
        }
    }
}
