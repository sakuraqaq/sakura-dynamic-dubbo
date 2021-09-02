package com.sakura.controller;


import com.sakura.enity.Paper;
import com.sakura.enity.SakuraOrder;
import com.sakura.service.OrderService;
import com.sakura.service.PaperService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : bi
 * @since : 2021年06月24日
 */
@RestController
@RequestMapping("/user")
public class LoginController {

    @DubboReference
    private OrderService orderService;

    @DubboReference
    private PaperService paperService;

    @GetMapping("/users")
    public String getUser()
    {
        SakuraOrder sakuraOrder = orderService.selectOrder(2134186429292544l, 2134186429292544l);
        //SakuraOrder sakuraOrder1 = orderService.selectOrder(2134186429292543l, 2134186429292543l);
        return sakuraOrder.toString();
    }


}
