package com.maven.project.web;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Controller;

import com.maven.project.tools.model.InfoConfig;
import com.maven.project.web.jedisPubSubListener.JedisPubSubLis;
import com.maven.project.web.jedisPubSubListener.SubscribeQueueThread;
import com.maven.project.web.netty4.NettyServer;

@Controller
public class SystemInitLoad {
	
	@Autowired
	private JedisPubSubLis jedisPubSubLis;
	
	@Autowired
	private InfoConfig infoConfig;

	@Autowired
	private TaskExecutor taskExecutor;
	
	@PostConstruct
	public void initMethod(){
		/** 启动redis消息订阅 监听 */
		taskExecutor.execute(new SubscribeQueueThread(jedisPubSubLis,infoConfig));
		
		/** 启动 netty servre*/
		taskExecutor.execute(new NettyServer());
	}
}
