package net.general.aggregation.mq.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author: dreamer Q
 * @Date: 2019/12/3 23:22
 * @Version 1.0
 * @Discription
 */
@Component
public class HelloReceiver1 {

    @RabbitListener(queues = "helloQueue")
    public void process(String hello) {
        System.out.println("Receiver1:" + hello);
    }

    @RabbitListener(queues = "helloQueue2")
    public void process2(String hello) {
        System.out.println("Receiver2:" + hello);
    }
}
