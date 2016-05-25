package com.maven.project.web.netty4;

import org.springframework.beans.factory.annotation.Autowired;

import com.maven.project.tools.redis.JredisOper;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class NettyServerHandler extends SimpleChannelInboundHandler<Object> {

	@Autowired
	private JredisOper jredisOper;
	
	@Override
	protected void channelRead0(ChannelHandlerContext paramChannelHandlerContext, Object paramI) throws Exception {
		System.out.println("=================channelRead0======================");
		jredisOper.setValue_str(Math.random()*9000+"", Math.random()*9000+"");
	}

}
