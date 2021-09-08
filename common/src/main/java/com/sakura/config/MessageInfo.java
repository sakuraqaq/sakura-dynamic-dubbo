package com.sakura.config;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Data
@Slf4j
public class MessageInfo {

    private String topic;

    private String tags;

    private String group;

    private String body;

    private String serverName;

    private Map<String, DefaultMQProducer> map = new HashMap<>();

    public void init() throws Exception {
        Message message = new Message(this.topic, this.tags, this.body.getBytes(StandardCharsets.UTF_8));
        SendResult sendResult =  getProducer(group).send(message);
        log.info("生产者信息={"+sendResult.toString()+"}");
    }

    public void start(DefaultMQProducer producer) {
        try {
            producer.start();
        } catch (MQClientException e) {
            e.printStackTrace();
        }
    }

    public DefaultMQProducer getProducer(String group) {
        if (map.containsKey(group)) {
            start(map.get(group));
            return map.get(group);
        }
        DefaultMQProducer producer = new DefaultMQProducer(group);
        producer.setNamesrvAddr(serverName);
        map.put(group, producer);
        start(producer);
        return producer;
    }
}
