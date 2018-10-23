package com.qianli.ilink.cloud_platform.messagecenter.heartBeat;

import java.net.*;

public class test {

    public static void main(String[] args) {
//        try {
//            send("heartBeat".getBytes("utf-8"),"127.0.0.1",12222,false);
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }

    }

//    private static void send(byte[] message, String host, int port,boolean isGZip) {
//        DatagramSocket ds = null;
//        try {
//            ds = new DatagramSocket();
//            byte[] bys;
//            if(isGZip){
//                bys = GZipUtil.compress(message);
//            }else {
//                bys = message;
//            }
//            DatagramPacket dp = new DatagramPacket(bys, bys.length, InetAddress.getByName(host), port);
//            ds.send(dp);
//        } catch (Exception e) {
//            System.out.print("send message fail..." + e.getLocalizedMessage());
//        } finally {
//            if (ds != null) {
//                ds.close();
//            }
//        }
//    }

}
