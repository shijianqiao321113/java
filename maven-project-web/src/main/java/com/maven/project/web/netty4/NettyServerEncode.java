package com.maven.project.web.netty4;

import java.nio.charset.Charset;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class NettyServerEncode extends MessageToByteEncoder {
	
	private Charset charset;
	
	public NettyServerEncode(Charset charset){
		this.charset=charset;
	}
	
	@Override
	protected void encode(ChannelHandlerContext paramChannelHandlerContext, Object paramI, ByteBuf paramByteBuf)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
