package com.maven.project.web.jedisPubSubListener;

import com.maven.project.tools.model.InfoConfig;
import com.maven.project.tools.utils.RedisKeyName;

import redis.clients.jedis.Jedis;

public class SubscribeQueueThread implements Runnable {

	private JedisPubSubLis jedisPubSubLis;
	
	private InfoConfig infoConfig;
	
	public SubscribeQueueThread(JedisPubSubLis jedisPubSubLis,InfoConfig infoConfig){
		this.jedisPubSubLis=jedisPubSubLis;
		this.infoConfig=infoConfig;
	}
	
	@Override
	public void run() {
		
		Jedis jr = null;
		boolean isInterrupt = Boolean.FALSE;
		 String pattern = RedisKeyName.SUBSCR+RedisKeyName.UNDERLINE+"*";
        try {
        	//redis服务地址和端口号,设置连接超市时间为0，代表连接为长连接，不超时
            jr = new Jedis(infoConfig.getRedisHost(), infoConfig.getRedisPort(), 0);
           
            //pubSub.proceed(jr.getClient(),channel);
            //采用通配符进行监听，监听所有的税务机关的空闲税务人员排队队列
            jedisPubSubLis.proceedWithPatterns(jr.getClient(), pattern);
        }catch(Exception e) {
        	//如果出现异常信息，采用重连机制，然后继续监听所有的税务机关的空闲税务人员的排队队列
        	try {
        		jr.connect();
        		jedisPubSubLis.proceedWithPatterns(jr.getClient(), pattern);
			} catch (Exception e2) {
				isInterrupt = Boolean.TRUE;
			}
        	e.printStackTrace();
        }finally{
            if(jr!=null && isInterrupt){
                jr.disconnect();
            }
        }
	}
}
