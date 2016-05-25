package com.maven.project.web.mina2;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

public class ServerHandler extends IoHandlerAdapter {

	/**当一个新客户端连接后触发此方法*/
	@Override 
	public void sessionCreated(IoSession session) throws Exception {
		System.out.println("===============sessionCreated=============");
	}

	/**当连接后打开时触发此方法，一般此方法与 sessionCreated 会被同时触发*/
	@Override
	public void sessionOpened(IoSession session) throws Exception {
		System.out.println("===============sessionOpened=============");
	}

	/**当连接被关闭时触发，例如客户端程序意外退出等等*/
	@Override
	public void sessionClosed(IoSession session) throws Exception {
		System.out.println("===============sessionClosed=============");
		if(null != session){
			session.closeOnFlush();
		}
	}

	/**当连接空闲时触发此方法*/
	@Override
	public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
		System.out.println("===============sessionIdle=============");
		this.sessionClosed(session);
	}

	/**当接口中其他方法抛出异常未被捕获时触发此方法*/
	@Override
	public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
		System.out.println("===============exceptionCaught=============");
		this.sessionClosed(session);
	}

	/**当接收到客户端的请求信息后触发此方法*/
	@Override
	public void messageReceived(IoSession session, Object message) throws Exception {
		System.out.println("===============messageReceived=============");
	}

	/**当信息已经传送给客户端后触发此方法*/
	@Override
	public void messageSent(IoSession session, Object message) throws Exception {
		System.out.println("===============messageSent=============");
	}

	@Override
	public void inputClosed(IoSession session) throws Exception {
		System.out.println("===============inputClosed=============");
		this.sessionClosed(session);
	}

}
