package com.maven.project.web.jmsMessageOper;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class TestMonitorQueue implements MessageListener {
	
	public void onMessage(Message message) {
		if (message instanceof TextMessage) {
			TextMessage textMessage = (TextMessage) message;
			try {
				System.out.println("============"+textMessage.getText());
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}
}
