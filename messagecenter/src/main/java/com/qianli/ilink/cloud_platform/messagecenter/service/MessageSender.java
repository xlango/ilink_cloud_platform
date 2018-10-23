package com.qianli.ilink.cloud_platform.messagecenter.service;

import com.qianli.ilink.cloud_platform.messagecenter.pojo.dto.Message;

public interface MessageSender {
    void send(Message message);
}
