package com.star.activemq.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by lcx on 2018/10/15.
 */
public class AppConsumer {

    private static final String url = "tcp://192.168.100.160:61616";

    private static final String user = "admin";

    private static final String password = "wzkj#2017#123";

    private static final String topicName = "topic-test";

    public static void main(String[] args) throws JMSException {

//        1.创建ConnectionFactory
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(user, password, url);

//        2.创建Connection
        Connection connection = connectionFactory.createConnection();

//        3.启动连接
        connection.start();

//        4.创建会话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

//        5.创建一个目标
        Destination destination = session.createTopic(topicName);

//        6.创建一个消费者
        MessageConsumer consumer = session.createConsumer(destination);

//        7.创建一个监听器
        consumer.setMessageListener(new MessageListener() {
//            异步监听消息
            @Override
            public void onMessage(Message message) {
                TextMessage textMessage = (TextMessage) message;
                try {
                    System.out.println("接受消息" + textMessage.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });


//        connection.close();

    }

}
