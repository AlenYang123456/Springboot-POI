package net.general.aggregation.controller;

import net.general.aggregation.mq.sender.Sender1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: dreamer Q
 * @Date: 2019/12/3 23:23
 * @Version 1.0
 * @Discription mq测试
 */
@RestController
public class RabbitController {
    @Autowired
    private Sender1 helloSender;

    @RequestMapping("/hello")
    public String hello() {
        helloSender.send();
        return "ok";
    }

    @RequestMapping("/hello2")
    public String hello2() {
        helloSender.send2();
        return "ok";
    }
}
