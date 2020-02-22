package com.star.activemq.jms.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.annotation.Resource;
import javax.jms.*;

/**
 * Created by lcx on 2018/10/15.
 */
public class ProducerServiceImp implements ProducerService {

    @Autowired
    private JmsTemplate jmsTemplate;

//    @Resource(name = "queueDest")
    @Resource(name = "topicDest")
    private Destination destination;

    @Override
    public void sendMessage(String message) {
//        使用jmsTemplate发送消息
        jmsTemplate.send(destination, new MessageCreator() {
            @Override
//            创建一个消息
            public Message createMessage(Session session) throws JMSException {
                TextMessage textMessage = session.createTextMessage(message);
                return textMessage;
            }
        });
        System.out.println("发送消息：" + message);
    }
}
