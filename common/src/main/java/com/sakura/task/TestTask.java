package com.sakura.task;

import com.sakura.component.RocketMQ;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import org.apache.rocketmq.common.message.Message;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TestTask extends RocketMQ {
    @Override
    public String getJobName() {
        return "testTask";
    }

    @Override
    protected ConsumeOrderlyStatus executeInternal(Message message, String params) {
        log.info("testTask");
        System.out.printf("consumer message boyd %s %n", new String(message.getBody()));
        return ConsumeOrderlyStatus.SUCCESS;
    }

    @Override
    protected String getTopic() {
        return "test_topic";
    }

    @Override
    protected String getGroup() {
        return "test_group";
    }

    @Override
    protected String getServer() {
        return "127.0.0,1:9876";
    }
}
