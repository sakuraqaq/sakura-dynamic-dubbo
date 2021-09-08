package com.sakura.controller;


import com.sakura.config.MessageInfo;
import com.sakura.service.OrderService;
import com.sakura.service.PaperService;
import lombok.RequiredArgsConstructor;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * @author : bi
 * @since : 2021年06月24日
 */
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class LoginController {

    @DubboReference
    private OrderService orderService;

    @DubboReference
    private PaperService paperService;

    @GetMapping("/users")
    public String getUser() throws Exception {
        ArrayList<String> mesList = new ArrayList<>();
        mesList.add("小小");
        mesList.add("爸爸");
        mesList.add("妈妈");
        mesList.add("爷爷");
        mesList.add("奶奶");

        //分别去往两个不同的task发送消息
        MessageInfo messageInfo1 = new MessageInfo();
        messageInfo1.setBody(mesList.toString());
        messageInfo1.setGroup("test_consumer");
        messageInfo1.setTopic("topic_family");
        messageInfo1.setTags("tag2");
        messageInfo1.setServerName("127.0.0.1:8976");
        messageInfo1.init();

        MessageInfo messageInfo = new MessageInfo();
        messageInfo.setBody(mesList.toString());
        messageInfo.setGroup("test_group");
        messageInfo.setTopic("test_topic");
        messageInfo.setTags("tag1");
        messageInfo.setServerName("127.0.0.1:8976");
        messageInfo.init();


        //        SakuraOrder sakuraOrder = orderService.selectOrder(2134186429292544l, 2134186429292544l);
//        //SakuraOrder sakuraOrder1 = orderService.selectOrder(2134186429292543l, 2134186429292543l);
//        return sakuraOrder.toString();
        return "成功";

    }


}
