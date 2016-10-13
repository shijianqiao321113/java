package com.maven.project.web.netty4;

import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.maven.project.tools.redis.JredisOper;

@Sharable
@Controller
public class NettyServerHandler extends SimpleChannelInboundHandler<Object>{
	
	@Autowired
	private JredisOper jredisOper;

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, Object msg)
			throws Exception {
		System.out.println("========jredisOper:"+jredisOper+"=========Server received: " + msg);
		ctx.channel().writeAndFlush("======"+msg+"======"+Math.random());
	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		System.out.println("======= netty ctx.channel().close() ========");
		ctx.channel().close();
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
			throws Exception {
		cause.printStackTrace();
		channelInactive(ctx);
	}
}
