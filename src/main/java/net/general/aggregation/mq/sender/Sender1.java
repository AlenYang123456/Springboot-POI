package net.general.aggregation.mq.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author: dreamer Q
 * @Date: 2019/12/3 23:21
 * @Version 1.0
 * @Discription
 */
@Component
public class Sender1 {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String sendMsg = "hello1 " + new Date();
        System.out.println("Sender1:" + sendMsg);
        rabbitTemplate.convertAndSend("helloQueue", sendMsg);
    }

    public void send2() {
        String sendMsg = "hello2 " + new Date();
        System.out.println("Sender2:" + sendMsg);
        rabbitTemplate.convertAndSend("helloQueue2", sendMsg);
    }
}
