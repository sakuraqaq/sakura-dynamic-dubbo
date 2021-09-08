package com.sakura.component;

import org.apache.rocketmq.client.exception.MQClientException;
import org.springframework.beans.BeansException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class JobInitService implements CommandLineRunner, ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        JobInitService.applicationContext = applicationContext;
    }
    @Override
    public void run(String... args) {
        if(applicationContext != null){
            Map<String, Job> dnicJobMap = applicationContext.getBeansOfType(Job.class);
            dnicJobMap.forEach((k,v)->{
                try {
                    v.execute();
                } catch (MQClientException e) {
                    e.printStackTrace();
                }
            });
        }

    }



}
