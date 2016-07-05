package com.maven.project.web.netty4;

import java.nio.charset.Charset;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class NettyServerEncoder extends MessageToByteEncoder<Object> {

	private Charset charset;
	
	public NettyServerEncoder(Charset charset){
		this.charset =  charset;
	}
	
	@Override
	protected void encode(ChannelHandlerContext ctx, Object msg, ByteBuf out){
//        out.writeInt(dataLength);  //先将消息长度写入，也就是消息头
        out.writeBytes(msg.toString().getBytes(this.charset));  //消息体中包含我们要发送的数据
	}
}
