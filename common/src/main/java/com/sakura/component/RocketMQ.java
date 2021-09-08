package com.sakura.component;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerOrderly;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.Message;


@Slf4j
public abstract class RocketMQ implements Job {

    private String params;

    @Override
    public void setParams(String params) {
        this.params = params;
    }

    @Override
    public void execute() {
        try {
            DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(getGroup());
            consumer.setNamesrvAddr(getServer());
            //消费模式:一个新得订阅组第一次启动从队列得最后位置开始消费 后续在启动接着上次消费得进度开始消费
            consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
            //订阅主题和标签 *代表所有标签 下信息
            consumer.subscribe(getTopic(), "*");
            //注册消费得监听 并在此监听中消费消息，并返回消费得状态消息
            consumer.registerMessageListener((MessageListenerOrderly) (msgs, context) -> {
                for (Message msg : msgs) {
                    return this.executeInternal(msg, params);
                }
                return ConsumeOrderlyStatus.SUCCESS;
            });
            consumer.start();
            log.info(this.getJobName() + "消费者 启动成功=======");
        }catch (MQClientException e){
            log.error(e.getMessage(), e);
        }
    }

    protected abstract ConsumeOrderlyStatus executeInternal(Message message, String params);

    protected abstract String getTopic();

    protected abstract String getGroup();

    protected abstract String getServer();
}
