package com.maven.project.web.netty4;

import java.nio.charset.Charset;
import java.util.List;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

public class NettyServerDecoder extends ByteToMessageDecoder {
	
	private Charset charset;
	
	public NettyServerDecoder(Charset charset){
		this.charset=charset;
	}

	@Override
	protected void decode(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf,
			List<Object> paramList) throws Exception {
		// TODO Auto-generated method stub

	}

}
