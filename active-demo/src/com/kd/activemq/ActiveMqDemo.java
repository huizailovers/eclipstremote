package com.kd.activemq;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class ActiveMqDemo {

	public static void main(String[] args) throws Exception {
		//获取到connectionfacroty
		ActiveMQConnectionFactory factory = new org.apache.activemq.ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_USER, ActiveMQConnectionFactory.DEFAULT_PASSWORD, ActiveMQConnectionFactory.DEFAULT_BROKER_BIND_URL);
		//创建connection
		Connection connection = factory.createConnection();
		connection.start();
		//创建session 签收的模式是自动的签收  
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		//消息发送和接收的地点
		Destination destination = session.createQueue("queue");
		//创建消息的提供者
		MessageProducer messageProducer = session.createProducer(destination);
		//创建消息
		TextMessage createMessage = session.createTextMessage();
		createMessage.setText("this is my first message");
		//发布消息
		messageProducer.send(createMessage);
		//关闭连接
		if(connection!=null){
			connection.close();
		}
		System.out.println("消息发送成功......");
	}
	/*public static void main(String[] args) throws Exception {
		//获取到connectionfacroty
		ActiveMQConnectionFactory factory = new org.apache.activemq.ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_USER, ActiveMQConnectionFactory.DEFAULT_PASSWORD, ActiveMQConnectionFactory.DEFAULT_BROKER_BIND_URL);
		//创建connection
		Connection connection = factory.createConnection();
		connection.start();
		//创建session 签收的模式是自动的签收  
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		//消息发送和接收的地点
		Destination destination = session.createQueue("queue");
		//创建消息的接受者
		MessageConsumer createConsumer = session.createConsumer(destination);
		//发布消息
		Message message = createConsumer.receive();
		System.out.println(message.toString());
		//关闭连接
		if(connection!=null){
			connection.close();
		}
		System.out.println("消息发送成功......");
		//ActiveMQTextMessage {commandId = 5, responseRequired = true, messageId = ID:EDZ-20170707KJY-54281-1500619385017-1:1:1:1:1, originalDestination = null, originalTransactionId = null, producerId = ID:EDZ-20170707KJY-54281-1500619385017-1:1:1:1, destination = queue://queue, transactionId = null, expiration = 0, timestamp = 1500619385282, arrival = 0, brokerInTime = 1500619385298, brokerOutTime = 1500619864875, correlationId = null, replyTo = null, persistent = true, type = null, priority = 4, groupID = null, groupSequence = 0, targetConsumerId = null, compressed = false, userID = null, content = org.apache.activemq.util.ByteSequence@47d384ee, marshalledProperties = null, dataStructure = null, redeliveryCounter = 0, size = 0, properties = null, readOnlyProperties = true, readOnlyBody = true, droppable = false, jmsXGroupFirstForConsumer = false, text = this is my first message}

	}*/

}
