package com.maven.project.web.mina2;

import java.nio.charset.Charset;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoder;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;

public class ServerEnCoder implements ProtocolEncoder {

	private Charset charset = null;

	public ServerEnCoder(Charset charset) {
		this.charset = charset;
	}

	@Override
	public void encode(IoSession session, Object message, ProtocolEncoderOutput out) throws Exception {
		IoBuffer buf = IoBuffer.allocate(message.toString().getBytes().length).setAutoExpand(true);
		buf.putString(message.toString(), charset.newEncoder());
		buf.flip();
		out.write(buf);
		return;
	}

	@Override
	public void dispose(IoSession session) throws Exception { }

}
