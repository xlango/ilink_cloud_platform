package com.qianli.ilink.cloud_platform.messagecenterudp.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Properties;

/**
 * @author yanghao
 */
@Slf4j
@Component
public class KafkaMessageSender{

    @Autowired
    private KafkaProducerConfig kafkaConfig;

    private KafkaProducer<String,String> producer;

    @PostConstruct
    public void start(){
        log.info("kafka producer initialize..");
        Properties properties = new Properties();
        properties.put("bootstrap.servers",kafkaConfig.getBootstrapServers());
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("retries", 0);
        properties.put("acks","1");
        properties.put("buffer.memory",33554432);
        //1s or 到达batch.size 发送一次
        properties.put("batch.size",kafkaConfig.getBatchSize());
        properties.put("linger.ms",kafkaConfig.getLingerMs());
        producer = new KafkaProducer<>(properties);
        log.info("kafka producer start successful..");
    }

    @PreDestroy
    public void destory(){
        producer.close();
        log.info("kafka producer shutdown successful..");
    }

    public void execute(String topic ,String key,String value){
        try{
            producer.send(new ProducerRecord<>(topic,key,value));
        }catch (Exception e){
            log.warn("kafka send fail...",e);
        }
    }

}
