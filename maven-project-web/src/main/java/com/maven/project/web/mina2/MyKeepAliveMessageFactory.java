package com.maven.project.web.mina2;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.keepalive.KeepAliveMessageFactory;

public class MyKeepAliveMessageFactory implements KeepAliveMessageFactory {
	
	private static final String RESULTMESSAGE = "123456789";
	
	private static final String SENDMESSAGE = "123";

	@Override
	public boolean isRequest(IoSession paramIoSession, Object message) {
		System.out.println("请求心跳包信息:"+message);
		if(message.equals(SENDMESSAGE)){
			return true;
		}
		return false;
	}

	@Override
	public boolean isResponse(IoSession paramIoSession, Object message) {
		System.out.println("响应心跳包信息:"+message);
		if(message.equals(RESULTMESSAGE)){
			return true;
		}
		return false;
	}

	@Override
	public Object getRequest(IoSession paramIoSession) {
		System.out.println("请求预设信息:"+SENDMESSAGE);
		return SENDMESSAGE;
	}

	@Override
	public Object getResponse(IoSession paramIoSession, Object message) {
		System.out.println("响应预设信息:"+RESULTMESSAGE);
		return RESULTMESSAGE;
	}

}
