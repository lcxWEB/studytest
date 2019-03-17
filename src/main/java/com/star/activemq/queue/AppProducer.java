package com.star.activemq.queue;


import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;


/**
 * Created by lcx on 2018/10/15.
 */
public class AppProducer {

    private static final String url= "tcp://192.168.100.160:61616";

    private static final String user = "admin";

    private static final String password = "wzkj#2017#123";

    private static final String queueName = "queue-test";

    public static void main(String[] args) throws JMSException {

//        1.创建ConnectionFactory
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(user, password, url);

//        2.创建Connection
        Connection  connection = connectionFactory.createConnection();

//        3.启动连接
        connection.start();

//        4.创建会话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

//        5.创建一个目标
        Destination destination = session.createQueue(queueName);

//        6.创建生产者
        MessageProducer producer = session.createProducer(destination);

//        7.发送消息
        for (int i = 0; i < 100; i++){
//            创建消息
            TextMessage textMessage = session.createTextMessage("test" + i);
//            发布消息
            producer.send(textMessage);

            System.out.println("发送消息" + textMessage);
        }

        connection.close();

    }

}
