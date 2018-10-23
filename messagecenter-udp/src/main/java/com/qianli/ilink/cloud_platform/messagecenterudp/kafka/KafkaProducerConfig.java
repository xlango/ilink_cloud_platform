package com.qianli.ilink.cloud_platform.messagecenterudp.kafka;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "kafka")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class KafkaProducerConfig {

    private String messageTopic;

    private String bootstrapServers;

    private int batchSize;

    private int lingerMs;

}
