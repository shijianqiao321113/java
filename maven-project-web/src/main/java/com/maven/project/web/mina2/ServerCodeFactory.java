package com.maven.project.web.mina2;

import java.nio.charset.Charset;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;

public class ServerCodeFactory implements ProtocolCodecFactory {

	private ServerEnCoder encoder;
	
	private ServerDecoder decoder;
	
	public ServerCodeFactory(){
		this(Charset.defaultCharset().name());
	}
	
	public ServerCodeFactory(String charsetName){
		encoder = new ServerEnCoder(Charset.forName(charsetName));
		decoder = new ServerDecoder(Charset.forName(charsetName));
	}
	
	@Override
	public ProtocolEncoder getEncoder(IoSession session) throws Exception {
		return encoder;
	}

	@Override
	public ProtocolDecoder getDecoder(IoSession session) throws Exception {
		return decoder;
	}

}
