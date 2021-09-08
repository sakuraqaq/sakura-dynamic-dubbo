package com.sakura.task;

import com.sakura.component.RocketMQ;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import org.apache.rocketmq.common.message.Message;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ConsumerTask extends RocketMQ {


    @Override
    public String getJobName() {
        return "consumer";
    }

    @Override
    protected ConsumeOrderlyStatus executeInternal(Message message, String params) {
        log.info(params + ":" + message.toString());
        return ConsumeOrderlyStatus.SUCCESS;
    }

    @Override
    protected String getTopic() {
        return "topic_family";
    }

    @Override
    protected String getGroup() {
        return "test_consumer";
    }

    @Override
    protected String getServer() {
        return "127.0.0.1:9876";
    }
}
