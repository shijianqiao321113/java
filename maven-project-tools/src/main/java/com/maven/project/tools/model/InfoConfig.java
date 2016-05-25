package com.maven.project.tools.model;

public class InfoConfig {
	
	private String redisHost;
	
	private int redisPort;
	
	private String nettyHost;
	
	private int nettyPort;

	public String getNettyHost() {
		return nettyHost;
	}

	public void setNettyHost(String nettyHost) {
		this.nettyHost = nettyHost;
	}

	public int getNettyPort() {
		return nettyPort;
	}

	public void setNettyPort(int nettyPort) {
		this.nettyPort = nettyPort;
	}

	public String getRedisHost() {
		return redisHost;
	}

	public void setRedisHost(String redisHost) {
		this.redisHost = redisHost;
	}

	public int getRedisPort() {
		return redisPort;
	}

	public void setRedisPort(int redisPort) {
		this.redisPort = redisPort;
	}

}
