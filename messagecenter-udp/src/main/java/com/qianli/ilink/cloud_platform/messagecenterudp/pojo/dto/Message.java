package com.qianli.ilink.cloud_platform.messagecenterudp.pojo.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Message {

    String type;
    String body;

}
