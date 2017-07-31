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
		//��ȡ��connectionfacroty
		ActiveMQConnectionFactory factory = new org.apache.activemq.ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_USER, ActiveMQConnectionFactory.DEFAULT_PASSWORD, ActiveMQConnectionFactory.DEFAULT_BROKER_BIND_URL);
		//����connection
		Connection connection = factory.createConnection();
		connection.start();
		//����session ǩ�յ�ģʽ���Զ���ǩ��  
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		//��Ϣ���ͺͽ��յĵص�
		Destination destination = session.createQueue("queue");
		//������Ϣ���ṩ��
		MessageProducer messageProducer = session.createProducer(destination);
		//������Ϣ
		TextMessage createMessage = session.createTextMessage();
		createMessage.setText("this is my first message");
		//������Ϣ
		messageProducer.send(createMessage);
		//�ر�����
		if(connection!=null){
			connection.close();
		}
		System.out.println("��Ϣ���ͳɹ�......");
	}
	/*public static void main(String[] args) throws Exception {
		//��ȡ��connectionfacroty
		ActiveMQConnectionFactory factory = new org.apache.activemq.ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_USER, ActiveMQConnectionFactory.DEFAULT_PASSWORD, ActiveMQConnectionFactory.DEFAULT_BROKER_BIND_URL);
		//����connection
		Connection connection = factory.createConnection();
		connection.start();
		//����session ǩ�յ�ģʽ���Զ���ǩ��  
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		//��Ϣ���ͺͽ��յĵص�
		Destination destination = session.createQueue("queue");
		//������Ϣ�Ľ�����
		MessageConsumer createConsumer = session.createConsumer(destination);
		//������Ϣ
		Message message = createConsumer.receive();
		System.out.println(message.toString());
		//�ر�����
		if(connection!=null){
			connection.close();
		}
		System.out.println("��Ϣ���ͳɹ�......");
		//ActiveMQTextMessage {commandId = 5, responseRequired = true, messageId = ID:EDZ-20170707KJY-54281-1500619385017-1:1:1:1:1, originalDestination = null, originalTransactionId = null, producerId = ID:EDZ-20170707KJY-54281-1500619385017-1:1:1:1, destination = queue://queue, transactionId = null, expiration = 0, timestamp = 1500619385282, arrival = 0, brokerInTime = 1500619385298, brokerOutTime = 1500619864875, correlationId = null, replyTo = null, persistent = true, type = null, priority = 4, groupID = null, groupSequence = 0, targetConsumerId = null, compressed = false, userID = null, content = org.apache.activemq.util.ByteSequence@47d384ee, marshalledProperties = null, dataStructure = null, redeliveryCounter = 0, size = 0, properties = null, readOnlyProperties = true, readOnlyBody = true, droppable = false, jmsXGroupFirstForConsumer = false, text = this is my first message}

	}*/

}
