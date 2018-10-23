package com.qianli.ilink.cloud_platform.messagecenter.pojo.dto;

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
