package com.maven.project.web.netty4;

import java.nio.charset.Charset;

import org.springframework.beans.factory.annotation.Autowired;

import com.maven.project.tools.model.InfoConfig;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.timeout.IdleStateHandler;

public class NettyServer implements Runnable{
	
	@Autowired
	private InfoConfig infoConfig;
	
	public void run() {
		/**用于分配处理业务线程的线程组个数 */
		final int BIZGROUPSIZE = Runtime.getRuntime().availableProcessors()*2;	//默认 Cpu*2
		/** 业务出现线程大小*/
		final int BIZTHREADSIZE = 8;
		final EventLoopGroup bossGroup = new NioEventLoopGroup(BIZGROUPSIZE);
		final EventLoopGroup workerGroup = new NioEventLoopGroup(BIZTHREADSIZE);
		try{
			ServerBootstrap b = new ServerBootstrap();
			b.group(bossGroup, workerGroup);
			b.channel(NioServerSocketChannel.class);
			b.childHandler(new ChannelInitializer<SocketChannel>() {
				@Override
				public void initChannel(SocketChannel ch) throws Exception {
					ChannelPipeline pipeline = ch.pipeline();
					pipeline.addLast("frameDecoder", new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 0, 4, 0, 4));
					pipeline.addLast("frameEncoder", new LengthFieldPrepender(4));
					pipeline.addLast("decoder", new NettyServerDecoder(Charset.defaultCharset()));
					pipeline.addLast("encoder", new NettyServerEncode(Charset.defaultCharset()));
					pipeline.addLast("idleStateHandler", new IdleStateHandler(20, 20, 10)); //心跳监测 读超时为20s，写超时为20s 全部空闲时间10s
					pipeline.addLast(new NettyServerHandler());
				}
			});
			b.bind(infoConfig.getNettyHost(),infoConfig.getRedisPort()).sync();
			System.out.println("Netty tcp 服务器启动成功");
		}catch(Exception ex){
			System.out.println("Netty tcp 服务器已启动异常");
			ex.printStackTrace();
		}finally{
			workerGroup.shutdownGracefully();
			bossGroup.shutdownGracefully();
		}
	}
}
