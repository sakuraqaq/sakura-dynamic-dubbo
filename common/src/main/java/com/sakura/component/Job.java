package com.sakura.component;

import org.apache.rocketmq.client.exception.MQClientException;

public interface Job {

    void execute() throws MQClientException;

    String getJobName();

    void setParams(String params);
}
