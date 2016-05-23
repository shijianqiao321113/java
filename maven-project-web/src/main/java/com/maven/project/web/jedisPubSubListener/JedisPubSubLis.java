package com.maven.project.web.jedisPubSubListener;

import org.springframework.stereotype.Component;

import redis.clients.jedis.JedisPubSub;

@Component
public class JedisPubSubLis extends JedisPubSub {

	// 取得订阅的消息后的处理  
	public void onMessage(String channel, String message) {

	}

	// 取得按表达式的方式订阅的消息后的处理   业务逻辑
	public void onPMessage(String pattern, String channel, String message) {
		System.out.println("==============onPMessage==========="+pattern + "=" + channel + "=" + message);  
	}

	// 初始化订阅时候的处理  
	public void onSubscribe(String channel, int subscribedChannels) {
		// TODO Auto-generated method stub

	}

	// 取消订阅时候的处理  
	public void onUnsubscribe(String channel, int subscribedChannels) {
		// TODO Auto-generated method stub

	}

	// 取消按表达式的方式订阅时候的处理  
	public void onPUnsubscribe(String pattern, int subscribedChannels) {
		// TODO Auto-generated method stub

	}

	 // 初始化按表达式的方式订阅时候的处理  
	public void onPSubscribe(String pattern, int subscribedChannels) {
		// TODO Auto-generated method stub

	}

}
