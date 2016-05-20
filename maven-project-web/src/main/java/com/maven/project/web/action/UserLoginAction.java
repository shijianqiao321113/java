package com.maven.project.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.maven.project.services.UserOperServices;
import com.maven.project.web.AsyncTest;
import com.maven.project.web.jmsMessageSender.MessageSender;
import com.maven.project.web.jmsMessageSender.SenderMessageQueueName;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Controller
@RequestMapping("/user")
public class UserLoginAction {

	@Autowired
	private UserOperServices userOperServices;
	
	@Autowired
	private MessageSender messageSender;
	
	@Autowired
	private JedisPool jedisPool;
	
	@Autowired
	private AsyncTest asyncTest;
	/**
	* @Title: login 
	* @Description: 用户登录 
	* @author shi_jianqiao   
	* @date 2016年5月11日 下午4:07:50 
	* @param request
	* @param response
	* void
	 */
	@RequestMapping("/login")
	public void login(HttpServletRequest request,HttpServletResponse response){
		
		messageSender.sendTextMessage(SenderMessageQueueName.JMS_TEST_SEND_MESSAGE_QUEUE,(int)(Math.random()*9000)+1000+"abc");
		
		Jedis jedis = jedisPool.getResource();
		try{
			jedis.set((int)(Math.random()*9000)+1000+"",System.currentTimeMillis()+"");
		}finally{
			jedisPool.returnResource(jedis);
		}
		
		asyncTest.initAsync();
		
		userOperServices.login(request, response);
	}
}
