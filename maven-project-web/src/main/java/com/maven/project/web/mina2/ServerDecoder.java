package com.maven.project.web.mina2;

import java.nio.charset.Charset;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.CumulativeProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;

public class ServerDecoder extends CumulativeProtocolDecoder {

	private static final int HANDLENGTH = 4;

	private Charset charset = null;

	public ServerDecoder(Charset charset) {
		this.charset = charset;
	}

	@Override
	protected boolean doDecode(IoSession session, IoBuffer in, ProtocolDecoderOutput out) throws Exception {
		if (in.remaining() < HANDLENGTH) {
			return false;
		}
		byte[] sizeBytes = new byte[HANDLENGTH];
		in.mark();// 标记当前位置，以便reset
		in.get(sizeBytes, 0, HANDLENGTH);// 读取4字节
		int size = Integer.parseInt(new String(sizeBytes, this.charset));
		in.reset();
		if (size > in.remaining()) {// 如果消息内容不够，则重置，相当于不读取size
			return false;// 父类接收新数据，以拼凑成完整数据
		} else {
			byte[] bytes = new byte[size];
			in.get(bytes, 0, size);
			out.write(new String(bytes, this.charset));
			if (in.remaining() > 0) {// 如果读取内容后还粘了包，就让父类再重读 一次，进行下一次解析
				return true;
			}
		}
		return false;// 处理成功，让父类进行接收下个包
	}
}
