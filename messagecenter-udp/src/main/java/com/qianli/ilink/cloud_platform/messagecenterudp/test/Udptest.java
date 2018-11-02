package com.qianli.ilink.cloud_platform.messagecenterudp.test;

import com.qianli.ilink.cloud_platform.messagecenterudp.pojo.dto.ApUserInfoProto;
import com.qianli.ilink.cloud_platform.messagecenterudp.pojo.dto.ProbeMessageProto;
import com.qianli.ilink.cloud_platform.messagecenterudp.pojo.dto.UserInternetLogProto;

import java.net.*;

public class Udptest {
    public static void main(String[] args) {
//        boolean b = sendHeartBeat("127.0.0.1:18080");
//        System.out.println(b);
        byte[] message = null;
        String host = "127.0.0.1";
        int port = 18873;
        for (int i = 0; i < 1; i++) {
            UserInternetLogProto.TotalUserInternetLog totalUserInternetLog = getTotalUserInternetLog();
            ApUserInfoProto.APUserInfo apUserInfo=getAPUserInfo();
            ProbeMessageProto.Probe_Message probeMessage = getProbeMessage();

            DatagramSocket ds = null;
            try {
                //message = totalUserInternetLog.toByteArray();
                message = probeMessage.toByteArray();
                ds = new DatagramSocket();
                byte[] bys;
                bys = message;

                    DatagramPacket dp = new DatagramPacket(bys, bys.length, InetAddress.getByName(host), port);
                    ds.send(dp);
                    ds.receive(dp);

            } catch (Exception e) {
                System.out.println("send message file");
            } finally {
                if (ds != null) {
                    ds.close();
                }
            }
        }
//        while (true){

//        }
    }


//    private static boolean sendHeartBeat(String udpServer) {
//        boolean flag;
//        Socket client = null;
//        try {
//            String ip = udpServer.split(":")[0];
//            Integer port = Integer.parseInt(udpServer.split(":")[1]);
//            client = new Socket();
//            InetSocketAddress address = new InetSocketAddress(ip,port);
//            client.connect(address, 1000);
//            flag = true;
//        } catch (IOException e) {
//           e.printStackTrace();
//            flag = false;
//        }finally{
//            if(client!=null){
//                try {
//                    client.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        return flag;
//    }

    private static ProbeMessageProto.Probe_Message getProbeMessage(){

        ProbeMessageProto.ProbePhoneInfo.Builder  probePhoneInfoBuilder=ProbeMessageProto.ProbePhoneInfo.newBuilder();
        probePhoneInfoBuilder.setProbeApMac("xxxxxxxxx");

        ProbeMessageProto.ProbeHotspotInfo.Builder  probeHotspotInfoBuilder=ProbeMessageProto.ProbeHotspotInfo.newBuilder();
        probeHotspotInfoBuilder.setProbeApMac("yyyyyyyyy");

        ProbeMessageProto.ProbeAPLocationInfo.Builder  probeAPLocationInfoBuilder=ProbeMessageProto.ProbeAPLocationInfo.newBuilder();
        probeAPLocationInfoBuilder.setProbeApMac("zzzzzzzzzzz");


        ProbeMessageProto.Probe_Message.Builder probeMessageBuilder=ProbeMessageProto.Probe_Message.newBuilder();
        probeMessageBuilder
                //.addProbeAPLocationInfo(probeAPLocationInfoBuilder);
                //.addProbeHotsportInfo(probeHotspotInfoBuilder);
                .addProbePhoneInfo(probePhoneInfoBuilder);
        return probeMessageBuilder.build();
    }


    private static ApUserInfoProto.APUserInfo getAPUserInfo(){
        ApUserInfoProto.UserAppInfo.Builder userInfoBuilder=ApUserInfoProto.UserAppInfo.newBuilder();
        userInfoBuilder.setApMac("apMac3");
        userInfoBuilder.setStaMac("staMac9");
        userInfoBuilder.setAppId(9);
        userInfoBuilder.setSrcIp(9);
        userInfoBuilder.setDestIp(9);
        userInfoBuilder.setProto(9);
        userInfoBuilder.setSrcPort(9);
        userInfoBuilder.setDestPort(9);
        userInfoBuilder.setTimestamp(System.currentTimeMillis());
        userInfoBuilder.setDestMac("test-ab-cd-ef-gk-lm-9");
        userInfoBuilder.setAppAccount("test");
        userInfoBuilder.setAppPassword("test");
        userInfoBuilder.setAppNickname("test");
        userInfoBuilder.setAppAvatar("test");
        userInfoBuilder.setTelephoneNumber("9");
        userInfoBuilder.setTelephoneImei("9");
        userInfoBuilder.setTelephoneMeid("9");
        userInfoBuilder.setTelephoneSystem("9");
        userInfoBuilder.setTelephoneModel("9");
        userInfoBuilder.setTelephoneImsi("9");
        userInfoBuilder.setTelephoneCpu("9");
        userInfoBuilder.setIdentityCard("9");
        userInfoBuilder.setAccessUrl("9");
        userInfoBuilder.setHttpMethod(ApUserInfoProto.HttpMethod.POST);
        userInfoBuilder.setGpsInfo("9");
        userInfoBuilder.setSearchKeyword("9");
        userInfoBuilder.setMailRecevier("9");
        userInfoBuilder.setMailSubject("9");
        userInfoBuilder.setMailContent("9");
        userInfoBuilder.setPostsTopics("9");
        userInfoBuilder.setPostsContent("9");



        ApUserInfoProto.APUserInfo.Builder builder=ApUserInfoProto.APUserInfo.newBuilder();
        builder.addUserAppInfo(userInfoBuilder);
        return builder.build();
    }




    private static UserInternetLogProto.TotalUserInternetLog getTotalUserInternetLog() {
        UserInternetLogProto.UserInternetLog.Builder userInternetLogBuilder = UserInternetLogProto.UserInternetLog.newBuilder();
        userInternetLogBuilder.setApMac("apMac");
        userInternetLogBuilder.setLogTimestamp(System.currentTimeMillis());
        userInternetLogBuilder.setAppServiceCode("app_service_code");
        userInternetLogBuilder.setStaIp("sta_ip");
        userInternetLogBuilder.setSrcPort("src_port");
        userInternetLogBuilder.setOutifIp("outif_ip");
        userInternetLogBuilder.setStartPort(1);
        userInternetLogBuilder.setEndPort(101);
        userInternetLogBuilder.setDestIp("dest_ip");
        userInternetLogBuilder.setStaMac("sta_mac");
        userInternetLogBuilder.setAppType("app_type");
        userInternetLogBuilder.setAccessUrl("access_url");
        userInternetLogBuilder.setGpsLongi("gps_longi");
        userInternetLogBuilder.setGpsLati("gps_lati");


        UserInternetLogProto.UserInternetLog.Builder userInternetLogBuilder1 = UserInternetLogProto.UserInternetLog.newBuilder();
        userInternetLogBuilder1.setApMac("apMac");
        userInternetLogBuilder1.setLogTimestamp(System.currentTimeMillis());
        userInternetLogBuilder1.setAppServiceCode("app_service_code");
        userInternetLogBuilder1.setStaIp("sta_ip");
        userInternetLogBuilder1.setSrcPort("src_port");
        userInternetLogBuilder1.setOutifIp("outif_ip");
        userInternetLogBuilder1.setStartPort(1);
        userInternetLogBuilder1.setEndPort(101);
        userInternetLogBuilder1.setDestIp("dest_ip");
        userInternetLogBuilder1.setStaMac("sta_mac");
        userInternetLogBuilder1.setAppType("app_type");
        userInternetLogBuilder1.setAccessUrl("access_url");
        userInternetLogBuilder1.setGpsLongi("gps_longi");
        userInternetLogBuilder1.setGpsLati("gps_lati");


        UserInternetLogProto.TotalUserInternetLog.Builder builder = UserInternetLogProto.TotalUserInternetLog.newBuilder();
        builder.addUserInternetLog(userInternetLogBuilder).addUserInternetLog(userInternetLogBuilder1);
        return builder.build();
    }

}
