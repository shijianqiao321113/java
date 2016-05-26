package com.maven.project.web.netty4;

import java.nio.charset.Charset;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.timeout.IdleStateHandler;

@Controller
public class NettyServer {
	
	/** 用于分配处理业务线程的线程组个数 */
	static final int BIZGROUPSIZE = Runtime.getRuntime().availableProcessors() * 2; // 默认
	/** 业务出现线程大小 */
	static final int BIZTHREADSIZE = 8;
	static final EventLoopGroup bossGroup = new NioEventLoopGroup(BIZGROUPSIZE);
	static final EventLoopGroup workerGroup = new NioEventLoopGroup(BIZTHREADSIZE);

	@Value("${netty.server.host}")
	String host;
	
	@Value("${netty.server.port}")
	String port;

	@Autowired
	private NettyServerHandler nettyServerHandler;

	@PostConstruct
	public void init() {
		try {
			ServerBootstrap b = new ServerBootstrap();
			b.group(bossGroup, workerGroup);
			b.channel(NioServerSocketChannel.class);
			b.childHandler(new ChannelInitializer<SocketChannel>() {
				public void initChannel(SocketChannel ch) throws Exception {
					ChannelPipeline pipeline = ch.pipeline();
					pipeline.addLast("decoder", new NettyServerDecoder(Charset.defaultCharset()));
					pipeline.addLast("encoder", new NettyServerEncode(Charset.defaultCharset()));
					pipeline.addLast("idleStateHandler", new IdleStateHandler(20, 20, 10)); // 心跳监测 ,读超时为20s，写超时为20s,全部空闲时间10s
					pipeline.addLast(nettyServerHandler);
				}
			});
			b.bind(this.host,Integer.parseInt(this.port)).sync();
			System.out.println("Netty tcp 服务器启动成功,======"+this.host+":"+this.port);
		} catch (Exception ex) {
			System.out.println("Netty tcp 服务器已启动异常");
			ex.printStackTrace();
			Destroy();
		}
	}
	
	@PreDestroy
	public void Destroy(){
		workerGroup.shutdownGracefully();
		bossGroup.shutdownGracefully();
	}
}
