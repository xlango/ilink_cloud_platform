package com.qianli.ilink.cloud_platform.messagecenter.httpTest;

import com.qianli.ilink.cloud_platform.messagecenter.pojo.dto.ApBaseInfoProto;
import com.qianli.ilink.cloud_platform.messagecenter.utils.OkHttpCliGen;
import okhttp3.*;
import org.junit.Test;

import java.io.IOException;

public class testApp {

    @Test
    public void testHttp(){
        for (int i = 0 ;i<1000;i++){
            ApBaseInfoProto.ApBaseInfo apBaseInfo = ApBaseInfoProto.ApBaseInfo.newBuilder().setStatus(1).setApMac("apMac").setApModel("apModel").setApWanip("apWainIp").build();
            OkHttpClient client = OkHttpCliGen.OKHTTP.getClient();
            MediaType protobuf = MediaType.parse("application/x-protobuf");//数据类型为json格式
            RequestBody requestBody = RequestBody.create(protobuf, apBaseInfo.toByteArray());
            Request request = new Request.Builder()
                    .addHeader("Content-Type", "application/x-protobuf")
                    .addHeader("accept", "application/x-protobuf")
                    .url("http://localhost:9000/apbaseinfo")
                    .post(requestBody)
                    .build();
            Call call = client.newCall(request);
            try {
                Response response = call.execute();
                if (response.isSuccessful() && response.body() != null) {
                    String message = new String(response.body().bytes(), "utf-8");
                    System.out.println(message);
                } else {
                    String message = new String(response.body().bytes(), "utf-8");
                    System.out.println(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
