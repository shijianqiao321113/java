package com.maven.project.web.netty4;

import java.nio.charset.Charset;
import java.util.List;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

public class NettyServerDecoder extends ByteToMessageDecoder {
	
	private static final int HANDLENGTH = 4;
	
	private Charset charset;
	
	public NettyServerDecoder(Charset charset){
		this.charset=charset;
	}

	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf in,List<Object> out) {
		if (in.readableBytes() < HANDLENGTH) {
			return ;
		}
		try{
			byte[] sizeBytes = new byte[HANDLENGTH];
			in.markReaderIndex();// 标记当前位置，以便reset
			in.readBytes(sizeBytes, 0, HANDLENGTH);// 读取4字节
			int size = Integer.parseInt(new String(sizeBytes, this.charset));
			in.resetReaderIndex();
			if (size > in.readableBytes()) {// 如果消息内容不够，则重置，相当于不读取size
				return ;// 父类接收新数据，以拼凑成完整数据
			} else {
				byte[] bytes = new byte[size];
				in.readBytes(bytes, 0, size);
				out.add(new String(bytes, this.charset));
				return ;
			}
		}catch(Exception ex){
			System.out.println("====netty====="+ex);
			ctx.channel().close();
			return ;
		}
	}
}
